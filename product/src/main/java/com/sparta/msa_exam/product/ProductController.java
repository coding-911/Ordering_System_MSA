package com.sparta.msa_exam.product;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Value("${server.port}") // 애플리케이션이 실행 중인 포트를 주입받습니다.
    private String serverPort;

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Server-Port", serverPort);
    }

    @GetMapping("/product")
    public String getProduct() {
        return "Product info!!!!! From port : " + serverPort;
    }
}
