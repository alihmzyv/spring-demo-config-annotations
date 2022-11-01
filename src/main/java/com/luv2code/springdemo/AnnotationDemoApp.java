package com.luv2code.springdemo;

import com.luv2code.springdemo.coaches.TennisCoach;
import com.luv2code.springdemo.fortuneservice.RandomFortuneService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Coach coachBean = context.getBean("thatSillyCoach", Coach.class);
//        System.out.println(coachBean.getDailyWorkout());
//        context.close();
//        Coach footballCoachBean = context.getBean("footballCoach", Coach.class);
//        System.out.println(footballCoachBean.getDailyWorkout());
        TennisCoach coachBean = context.getBean("tennisCoach", TennisCoach.class);
//        System.out.println(coachBean.getDailyWorkout());
//        System.out.println(coachBean.getFortune());
        System.out.println(coachBean);
//        System.out.println(new TennisCoach(new RandomFortuneService(), "email@gmail.com", "tenniss"));
//        System.out.printf("Football coach is null: %s\n", coachBean.getFootballCoach() == null ? "yes" : "no");
        context.close();
    }
}
