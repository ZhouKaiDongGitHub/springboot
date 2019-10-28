package com.kzhou.spring.observer.WeatherStation;

/**
 * Observer: Subject
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
