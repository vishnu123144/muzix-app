package com.stackroute.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GatewayApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplicationMain.class, args);
    }

}
