package com.niu.sso.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * OAuth2 认证服务器
 *
 * @author [nza]
 * @version 1.0 2020/10/7
 * @createTime 2020/10/7
 */
@Configuration
@EnableAuthorizationServer
public class SsoAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client-A")
                .secret("secret-A")
                .authorizedGrantTypes("authorization_code", "refresh-token")
                .scopes("all")
                .and()
                .withClient("client-B")
                .secret("secret-B")
                .authorizedGrantTypes("authorization_code", "refresh-token")
                .scopes("all");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jwtTokenStore())
                .accessTokenConverter(jwtAccessTokenConverter());
    }

    /**
     * 认证服务器安全配置
     * @param security
     * @throws {@link Exception}
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 授权表达式, 访问tokenKey需要认证
        security.tokenKeyAccess("isAuthenticated()");
    }

    /**
     * Token 存储模式配置
     * @return {@link TokenStore}
     */
    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * 负责token生成
     *
     * @return JwtAccessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        // 设置 jwt 签名
        accessTokenConverter.setSigningKey("signingKey");
        return accessTokenConverter;
    }
}
