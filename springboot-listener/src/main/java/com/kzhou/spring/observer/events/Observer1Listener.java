package com.kzhou.spring.observer.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 观察者：观察者中主题状态改变，将直接委托观察者的引用，通知观察者，观察者收到通知，
 * update并且display
 *
 * Spring中Listener就是观察者，它也被通知了bean的改变，然后在onApplicationEvent中处理通知
 * 后逻辑，通过泛型表明处理的事件类型，Spring已经帮助实例化一个事件对象了
 */
@Component
public class Observer1Listener implements ApplicationListener<WeatherDataChangeEvent> {

    private float temperature;
    private float humidity;


    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    public void onApplicationEvent(WeatherDataChangeEvent weatherDataChangeEvent) {
        this.temperature = weatherDataChangeEvent.getTemperature();
        this.humidity = weatherDataChangeEvent.getHumidity();
        display();
    }
}
