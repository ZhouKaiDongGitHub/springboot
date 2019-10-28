package com.luban.kzhou.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.luban.kzhou")
@EnableAspectJAutoProxy
public class AppConfig {

}
