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
    public ResponseEntity<String> getProduct() {
        throw new RuntimeException("Lỗi tạm thời");
    }

}
