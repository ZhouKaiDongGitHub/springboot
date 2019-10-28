package com.luban.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * websocket's config class
 * config an message broker to process request
 * registe a queue to store subscriber
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * config request method to process various requests
     * @param config
     */
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //subscribe theme name
        config.enableSimpleBroker("/topic","/user");
        System.out.println("------------/topic /user Broker run-------------");
        //route application request to controller
        config.setApplicationDestinationPrefixes("/app");
        System.out.println("--------------------/app run---------------------------");
        //route application request to rebbitMQ
        //config.setUserDestinationPrefix("/rebbitmq");
    }

    /**
     * registe method with SockJS
     * @param registry
     */
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/luban").withSockJS();
        System.out.println("----------------/luban Server registe---------------------");
    }

}