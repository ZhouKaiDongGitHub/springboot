package com.luban.kzhou.aspect;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

public class AspectPrograme {

    public void doBefore(JoinPoint joinPoint){
        System.out.println("---------前置：切面程序：执行doBefore方法-------");
        System.out.println(joinPoint.getArgs());
        System.out.println(joinPoint.getSignature());
        System.out.println(joinPoint.getTarget());
    }

    public void doAfter(JoinPoint joinPoint,Object ret){
        System.out.println("---------后置：切面程序：执行doAfter方法-------");
        System.out.println(joinPoint.getArgs());
        System.out.println(joinPoint.getSignature());
        System.out.println(joinPoint.getTarget());
        System.out.println(ret);
    }

    public void doAround(ProceedingJoinPoint joinPoint){
        System.out.println("---------环绕：目标组件前：程序--------------");
        try {
            joinPoint.proceed();
            System.out.println("---------环绕：目标组件后：程序--------------");
        } catch (Throwable throwable) {
            System.out.println("---------环绕：目标组件异常：程序--------------");
            throwable.printStackTrace();
        }
        System.out.println("---------环绕：目标组件最终：程序--------------");
    }
}
