package com.kzhou.spring.observer.events;

import com.kzhou.spring.observer.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ApplicationContext在运行期会自动检测到所有实现了ApplicationListener的bean对象，并将其作为事件接收对象。
 * 当ApplicationContext的publishEvent方法被触发时，每个实现了ApplicationListener接口的bean都会收到ApplicationEvent对象，
 * 每个ApplicationListener可根据事件类型只接收处理自己感兴趣的事件，比如上面的Observer1Listener只接收WeatherDataChangeEvent事件。
 */
public class WeatherStation {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        WeatherDataChangeBean weatherDataChangeBean = annotationConfigApplicationContext.getBean(WeatherDataChangeBean.class);
        weatherDataChangeBean.dataChanget(80, 65, 30.4f);
    }
}
