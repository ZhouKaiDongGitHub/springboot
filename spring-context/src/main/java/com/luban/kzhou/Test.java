package com.luban.kzhou;

import com.luban.kzhou.aspect.PointCut;
import com.luban.kzhou.aspect.PointCut2;
import com.luban.kzhou.aspect.PointCut3;
import com.luban.kzhou.service.OrderService;
import com.luban.kzhou.service.PowerService;
import com.luban.kzhou.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring IOC 模块主要是对bean的管理
 * bean的注入方式有：setter  contractor（手动）  byType/byName（自动）
 * spring的编码方式有：XML annotation javaConfig
 */
public class Test {

    public static void main(String[] args) {
        //XML
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        IndexService service = (IndexService) context.getBean("indexService");
        service.query();*/
        //annotation+javaConfig
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configer.class);
        IndexService service = (IndexService) context.getBean("indexService");
        service.query();*/
        //cycle depandence
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configer.class);
        UserService userService = (UserService) context.getBean("userService");
        OrderService orderService = (OrderService) context.getBean("orderService");
        PowerService powerService = (PowerService) context.getBean("powerService");*/
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        /*PointCut pointcut =  (PointCut) context.getBean("pointCut11");
        pointcut.save("kzhou");*/
        PointCut3 pointcut =  (PointCut3) context.getBean(PointCut3.class);
        pointcut.save("kzhou");
        ApplicationContext
    }
}
