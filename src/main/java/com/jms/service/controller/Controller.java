package com.jms.service.controller;

import com.jms.model.Product;
import com.jms.service.model.ResponseEnum;
import com.jms.service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    private ProductService productService;

    public Controller(ProductService productService){
       this.productService = productService;
    }

    @PostMapping("/send/product/queue")
    public ResponseEntity<String> sendQueueMessage(@RequestBody @Valid Product product) throws JMSException {
        productService.sendQueueProduct(product);
        return new ResponseEntity<>(ResponseEnum.SUCCESSFULLY.getValue(),HttpStatus.OK);
    }
}
