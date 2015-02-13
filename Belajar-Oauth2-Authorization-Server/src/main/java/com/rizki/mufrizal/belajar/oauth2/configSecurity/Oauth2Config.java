package com.rizki.mufrizal.belajar.oauth2.configSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class Oauth2Config {

    private static final String RESOURCE_ID = "BelajarOauth2";

    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationConfig extends AuthorizationServerConfigurerAdapter{

        @Autowired
        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer) throws Exception{
            authorizationServerEndpointsConfigurer
                    .tokenStore(new InMemoryTokenStore())
                    .authenticationManager(authenticationManager);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) throws Exception{
            authorizationServerSecurityConfigurer.checkTokenAccess("hasRole('CLIENT')");
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception{
            clientDetailsServiceConfigurer
                    .inMemory()
                    .withClient("clientauthcode")
                    .secret("123456")
                    .authorizedGrantTypes("authorization_code", "refresh_token")
                    .scopes("read", "write")
                    .resourceIds(RESOURCE_ID)
                    .and()
                    .withClient("clientcred")
                    .secret("123456")
                    .authorizedGrantTypes("client_credentials")
                    .scopes("trust")
                    .resourceIds(RESOURCE_ID)
                    .and()
                    .withClient("clientapp")
                    .secret("123456")
                    .authorizedGrantTypes("password")
                    .scopes("read", "write")
                    .resourceIds(RESOURCE_ID)
                    .and()
                    .withClient("angularClient")
                    .secret("angularPassword")
                    .authorizedGrantTypes("implicit")
                    .scopes("read", "write")
                    .resourceIds(RESOURCE_ID)
                    .authorities("CLIENT")
                    .redirectUris("http://localhost:20000/implicit-client/")
                    .accessTokenValiditySeconds(60 * 60 * 24) // token berlaku seharian, besok harus login ulang
                    .autoApprove(true);
        }

    }

}