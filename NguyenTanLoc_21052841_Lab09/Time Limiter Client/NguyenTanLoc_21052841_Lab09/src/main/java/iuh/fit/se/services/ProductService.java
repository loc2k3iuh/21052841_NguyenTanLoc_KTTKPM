package iuh.fit.se.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {

    private final RestTemplate restTemplate;

    public ProductService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @TimeLimiter(name = "productService", fallbackMethod = "timeoutFallback")
    @CircuitBreaker(name = "productService", fallbackMethod = "timeoutFallback")
    public CompletableFuture<String> getProduct() {
        return CompletableFuture.supplyAsync(() -> {
            // Giả lập chậm trễ
            try {
                Thread.sleep(4000); // 4s > timeout → sẽ trigger fallback
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return restTemplate.getForObject("http://localhost:8081/api/product", String.class);
        });
    }

    public CompletableFuture<String> timeoutFallback(Throwable t) {
        return CompletableFuture.completedFuture("Dịch vụ phản hồi quá chậm. Vui lòng thử lại sau! 🕒");
    }
}