package com.samir.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication
{
    static CouList ourCouList;

    public static void main(String[] args)
    {
        ourCouList = new CouList();
        SpringApplication.run(CountriesApplication.class, args);
    }

}
