package com.example.ecommerceplatform.config;

import com.example.ecommerceplatform.ws.ProductServiceWSImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import jakarta.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public EndpointImpl endpoint(ProductServiceWSImpl productServiceWS, Bus bus) {
        EndpointImpl endpoint = new EndpointImpl(bus, productServiceWS);
        endpoint.publish("/ProductService");
        return endpoint;
    }
}
