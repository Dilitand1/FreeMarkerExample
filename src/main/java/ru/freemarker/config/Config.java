package ru.freemarker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
public class Config {

    @Bean(name = "ConfigTemplate")
    public freemarker.template.Configuration myConfig() throws IOException {
        // Конфигурация
        freemarker.template.Configuration templateConfig = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_27);
        templateConfig.setDirectoryForTemplateLoading(new ClassPathResource("templates").getFile());
        return templateConfig;
    }

}
