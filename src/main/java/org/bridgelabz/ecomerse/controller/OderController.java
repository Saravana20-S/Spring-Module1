package org.bridgelabz.ecomerse.controller;

import org.bridgelabz.ecomerse.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.SSLEngineResult;
import javax.print.attribute.standard.OrientationRequested;

@RestController
public class OderController {

    private final OrderService orderService;

    public OderController(OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save());
    }

    @GetMapping("/getall")
    public ResponseEntity<String> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAll());
    }

}
