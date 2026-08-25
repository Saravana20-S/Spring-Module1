package org.bridgelabz.ecomerse.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AllInOne {
    public String save(){
        return "Saved";
    }

    public String findAll(){
        return "Returned all";
    }
}
