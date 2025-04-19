package iuh.fit.se.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private final RestTemplate restTemplate;

    public ProductService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @RateLimiter(name = "productService", fallbackMethod = "rateLimitFallback")
    public String getProduct() {
        return restTemplate.getForObject("http://localhost:8081/api/product", String.class);
    }

    public String fallback(Throwable t) {
        return "Dịch vụ sản phẩm hiện tại không khả dụng 😵‍💫";
    }
}