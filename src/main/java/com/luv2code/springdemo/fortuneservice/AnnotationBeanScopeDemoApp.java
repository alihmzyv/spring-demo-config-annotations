package com.luv2code.springdemo.fortuneservice;

import com.luv2code.springdemo.coaches.Coach;
import com.luv2code.springdemo.coaches.TennisCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach tennisCoachBean = context.getBean("tennisCoach", Coach.class);
        Coach tennisCoachBean2 = context.getBean("tennisCoach", Coach.class);
        System.out.printf("They are the same: %s\n", tennisCoachBean2 == tennisCoachBean ? "yes" : "no");
        context.close();
    }
}
