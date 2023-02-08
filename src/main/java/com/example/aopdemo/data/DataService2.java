package com.example.aopdemo.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {

    public int[] findData(){
        return new int[] {10,11,2,34,53,8};
    }
}
