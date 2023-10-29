package com.example.xmlanalysis.config;

import com.google.gson.GsonBuilder;
import lombok.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class GsonConfig {
    // 将解析器注入Spring容器，替代默认的解析器
    @Bean
    public HttpMessageConverters customConverters() {
        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(new GsonBuilder().setDateFormat("yyyy-MM-dd").create());
        messageConverters.add(converter);
        return new HttpMessageConverters(true, messageConverters);
    }
}

