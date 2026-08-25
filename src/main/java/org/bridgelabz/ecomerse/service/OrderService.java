package org.bridgelabz.ecomerse.service;

import jakarta.transaction.Transactional;
import org.bridgelabz.ecomerse.repository.AllInOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final AllInOne allInOne;

    @Autowired
    public OrderService(AllInOne allInOne){
        this.allInOne=allInOne;
    }

    public String save(){
        return allInOne.save();
    }

    public String findAll(){
        return allInOne.findAll();
    }

    @Transactional
    public String update(){
        allInOne.findAll();
        System.out.println("one more added");
        allInOne.save();
        return "Transaction Successfull";
    }





}
