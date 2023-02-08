package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonAspect {

    @Pointcut(value = "@annotation(com.example.aopdemo.annotations.TrackTime)")
    public void trackTimeAnnotation(){}
}
