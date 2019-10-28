package com.kzhou.spring.observer.events;

import org.springframework.context.ApplicationEvent;

/**
 * 观察者：观察者中没有事件这个抽象类的概念，它直接就是主题的状态改变
 *
 * Spring在观察者基础上封上一层事件的概念，表明主题的状态改变了，
 * 需要通知监听者（观察者）的事件
 */
public class WeatherDataChangeEvent extends ApplicationEvent {

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataChangeEvent(Object source,float temperature,float humidity,float pressure) {
        super(source);
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
