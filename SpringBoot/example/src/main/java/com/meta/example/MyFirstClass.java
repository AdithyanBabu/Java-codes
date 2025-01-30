package com.meta.example;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class MyFirstClass {

    private String myvar;

    public MyFirstClass(String myvar) {
        this.myvar = myvar;
    }


    public String hello(){
        return "HEllo boouuyy, value = " + myvar;
    }
}
