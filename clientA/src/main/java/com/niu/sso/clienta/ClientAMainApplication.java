package com.niu.sso.clienta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;


/**
 * Client A 启动类
 *
 * @author [nza]
 * @version 1.0 2020/10/18
 */
@SpringBootApplication
@EnableOAuth2Sso
public class ClientAMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientAMainApplication.class, args);
    }
}
