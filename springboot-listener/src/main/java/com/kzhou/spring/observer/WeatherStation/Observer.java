package com.kzhou.spring.observer.WeatherStation;

/**
 * Observer: Observer
 */
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
