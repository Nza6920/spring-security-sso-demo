package com.niu.sso.clientb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * Client B 应用入口
 *
 * @author [nza]
 * @version 1.0 2020/10/18
 * @createTime 11:27
 */
@SpringBootApplication
@EnableOAuth2Sso
public class ClientBMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientBMainApplication.class, args);
    }
}
