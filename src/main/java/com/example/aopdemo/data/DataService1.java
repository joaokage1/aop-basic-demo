package com.example.aopdemo.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] findData(){
        return new int[] {1,1,2,3,5,8};
    }
}
