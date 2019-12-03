package com.uniajc.diplomado.service.proxy.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableZuulProxy
@EnableSwagger2
public class ProxyApplication
{

    public static void main (String[] args)
    {
        SpringApplication.run (ProxyApplication.class, args);
    }

}

// Michelin 185/65 rin 15
