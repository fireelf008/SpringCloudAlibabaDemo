package com.nacos.producer.config;

import com.nacos.producer.interceptors.SeataRestTemplateInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 初始化RestTemplate
 * @author wsf
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new SeataRestTemplateInterceptor());
        return restTemplate;
    }
}
