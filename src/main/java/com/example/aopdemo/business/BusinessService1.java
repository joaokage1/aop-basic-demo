package com.example.aopdemo.business;

import com.example.aopdemo.data.DataService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    @Autowired
    private DataService1 dataService1;

    public int calculateMax() {
        int[] data = dataService1.findData();

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //throw new RuntimeException("Something went wrong");
        return Arrays.stream(data).max().orElse(0);
    }
}
