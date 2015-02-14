package com.rizki.mufrizal.belajar.oauth2.configSecurity;

import com.rizki.mufrizal.belajar.oauth2.filter.CORSFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
public class Oauth2Config {

    private static final String RESOURCE_ID = "BelajarOauth2";

    @Configuration
    @Order(10)
    protected static class NonConfigOauth2 extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity
                    .authorizeRequests()
                    .antMatchers("/hello").permitAll()
                    .antMatchers("/**").permitAll()
                    .and()
                    .anonymous()
                    .and()
                    .addFilterBefore(new CORSFilter(), ChannelProcessingFilter.class);
        }

    }

    @Configuration
    @EnableResourceServer
    protected static class configOauth2 extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resourceServerSecurityConfigurer) throws Exception {
            RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
            remoteTokenServices.setClientId("angularClient");
            remoteTokenServices.setClientSecret("angularPassword");
            remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8002/Belajar-Oauth2-Authorization-Server/oauth/check_token");

            resourceServerSecurityConfigurer
                    .resourceId(RESOURCE_ID)
                    .tokenServices(remoteTokenServices);
        }

        @Override
        public void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity
                    .authorizeRequests()
                    .antMatchers("/admin").hasRole("ADMIN");
        }

    }

}
