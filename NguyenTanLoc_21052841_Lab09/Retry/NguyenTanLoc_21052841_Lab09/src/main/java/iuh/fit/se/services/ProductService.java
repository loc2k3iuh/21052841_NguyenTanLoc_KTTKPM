package iuh.fit.se.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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

    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackGetProduct")
    @Retry(name = "productService", fallbackMethod = "fallbackGetProduct")
    public String getProduct() {
        return restTemplate.getForObject("http://localhost:8081/api/product", String.class);
    }

    public String fallbackGetProduct(Exception ex) {
        return "Sản phẩm tạm thời không khả dụng. (Retry cũng bó tay 🤕)";
    }
}