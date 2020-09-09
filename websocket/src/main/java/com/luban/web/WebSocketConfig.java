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
 *
 * WebSocket是SpringMVC的东西，本质是一个前后台的发布-订阅模式，也叫做观察者设计模式
 * 定义了对象之间的一对多对应关系，这样，当一个对象的状态改变，其他对象都能收到消息并自动改变自己的状态
 *
 * 必须有两端
 *  服务器端：（主题中心端）
 *  客户端：（订阅者端）
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
        //定义了两个主题以及对应的中心端
        config.enableSimpleBroker("/topic","/user");
        //route application request to controller
        //消息路由的目的地，从前端来的消息，目的地可以是后台，也可以是其他的中间件
        config.setApplicationDestinationPrefixes("/app");
        //route application request to rebbitMQ
        //config.setUserDestinationPrefix("/rebbitmq");
    }

    /**
     * registe method with SockJS
     * @param registry
     */
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //定义了UI端如何注册
        registry.addEndpoint("/luban").withSockJS();
    }

}