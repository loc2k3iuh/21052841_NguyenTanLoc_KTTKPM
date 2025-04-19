package iuh.fit.se.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> getProduct() {
        Map<String, Object> product = new HashMap<>();
        product.put("id", 1);
        product.put("name", "Tai nghe Bluetooth");
        product.put("price", 299000);
        product.put("available", true);

        return ResponseEntity.ok(product);
    }

}
