package com.kzhou.spring.observer.events;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 观察者中主题的状态改变，我们是通过外部触发的，例如传到数据中心的天气数据发生改变触发接口，
 * 或者直接调用主题的setMeasurements方法。
 *
 * Spring是一个基于Bean的框架，主题的状态改变，或者说发生了一个事件（天气数据的改变），
 * 需要将这个事件告诉监听者（观察者）
 */
@Component
public class WeatherDataChangeBean {

    @Autowired
    private ApplicationContext applicationContext;
    WeatherDataChangeBean(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    /**
     * 增加一个天气数据改变的事件
     * @param
     */
    public void dataChanget(float temperature,float humidity,float pressure) {
        // 1.构造一个天气数据改变的事件
        WeatherDataChangeEvent weatherDataChangeEvent = new WeatherDataChangeEvent(applicationContext,
                temperature, humidity, pressure);
        // 2.触发事件
        applicationContext.publishEvent(weatherDataChangeEvent);
    }
}
