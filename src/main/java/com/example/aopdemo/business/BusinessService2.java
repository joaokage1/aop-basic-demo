package com.example.aopdemo.business;

import com.example.aopdemo.annotations.TrackTime;
import com.example.aopdemo.data.DataService1;
import com.example.aopdemo.data.DataService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {

    @Autowired
    private DataService2 dataService2;

    @TrackTime
    public int calculateMin() {
        int[] data = dataService2.findData();

        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //throw new RuntimeException("Something went wrong");
        return Arrays.stream(data).min().orElse(0);
    }
}
