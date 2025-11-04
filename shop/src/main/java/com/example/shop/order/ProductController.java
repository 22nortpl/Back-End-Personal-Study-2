package com.example.shop.product;


import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.member.dto.MemberUpdateRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody ProductCreateRequest request) {
        Long productName = productService.createProduct(request);
        return ResponseEntity.created(URI.create("/products/" + productName)).build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllMembers() {
        // Service 계층에서 회원 목록을 가져온다
        List<Product> members = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }


    @GetMapping("/{productName}")
    public ResponseEntity<Product> getMember(@PathVariable Long productName) {
        Product product = productService.getProductByName(productName);
        return ResponseEntity.ok(product);
    }

    @PatchMapping("/{productName}")
    public ResponseEntity<Void> updateMember(
            @PathVariable Long productName,
            @RequestBody ProductUpdateRequest request) {
        productService.updateMember(productName, request);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{productName}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build(); // 204 no content
    }



}