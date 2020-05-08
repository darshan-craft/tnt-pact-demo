package org.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PactDemoClientConfig {
    
    @Bean
    public RestOperations createRestTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
        
        return new RestTemplate(clientHttpRequestFactory);
    }
    
    @Bean
    public ClientHttpRequestFactory createClientHttpRequestFactory(
            @Value("${connect.timeout}") final int connectTimeout, @Value("${read.timeout}") int readTimeout) {
        
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(connectTimeout);
        factory.setReadTimeout(readTimeout);
        return factory;
    }
}
