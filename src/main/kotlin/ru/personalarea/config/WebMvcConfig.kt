package ru.personalarea.config

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import java.text.SimpleDateFormat


@Configuration
class WebMvcConfig {
    @Bean
    fun mappingJackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter? {
        val converter = MappingJackson2HttpMessageConverter()
        val mapper = converter.objectMapper
        val hibernate5Module = Hibernate5Module()
        mapper.registerModule(hibernate5Module)
        mapper.dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return converter
    }

    fun addViewControllers(registry: ViewControllerRegistry) {
//        registry.addViewController("/home").setViewName("home")
//        registry.addViewController("/").setViewName("home")
//        registry.addViewController("/hello").setViewName("hello")
        registry.addViewController("/login").setViewName("login")
    }
}