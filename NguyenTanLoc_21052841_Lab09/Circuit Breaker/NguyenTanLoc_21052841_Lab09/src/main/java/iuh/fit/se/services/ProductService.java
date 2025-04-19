package iuh.fit.se.services;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
    public String getProduct() {
        return restTemplate.getForObject("http://localhost:8081/api/product", String.class);
    }

    // Fallback nếu product-service lỗi
    public String fallbackGetProduct(Exception e) {
        return "Sản phẩm tạm thời không khả dụng. Vui lòng thử lại sau.";
    }
}
