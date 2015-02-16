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
    protected static class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

        @Autowired
        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer) throws Exception {
            authorizationServerEndpointsConfigurer
                    .tokenStore(new InMemoryTokenStore())
                    .authenticationManager(authenticationManager);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) throws Exception {
            authorizationServerSecurityConfigurer.checkTokenAccess("hasRole('CLIENT')");
            authorizationServerSecurityConfigurer.checkTokenAccess("hasRole('USER')");
            authorizationServerSecurityConfigurer.checkTokenAccess("hasRole('ADMIN')");
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception {
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
                        .withClient("jsclient")
                            .secret("jspasswd")
                            .authorizedGrantTypes("implicit")
                            .scopes("read", "write")
                            .resourceIds(RESOURCE_ID)
                            .authorities("CLIENT", "USER", "ADMIN")
                            .redirectUris("http://localhost:8000/index")
                            .accessTokenValiditySeconds(60 * 60 * 24) //untuk sehari
                            .autoApprove(true);
        }

    }

}
