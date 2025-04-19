package iuh.fit.se.controllers;

import iuh.fit.se.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ProductService productService;

    @GetMapping("/create")
    public String createOrder() {
        return "Đặt hàng thành công với sản phẩm: " + productService.getProduct();
    }
}
