package com.luv2code.springdemo;

import com.luv2code.springdemo.coaches.Coach;
import com.luv2code.springdemo.coaches.SwimCoach;
import com.luv2code.springdemo.coaches.TennisCoach;
import com.luv2code.springdemo.fortuneservice.HappyFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
//        Coach coachBean = context.getBean("thatSillyCoach", Coach.class);
//        System.out.println(coachBean.getDailyWorkout());
//        context.close();
//        Coach footballCoachBean = context.getBean("footballCoach", Coach.class);
//        System.out.println(footballCoachBean.getDailyWorkout());
        SwimCoach swimCoachBean = context.getBean("swimCoach", SwimCoach.class);
//        TennisCoach tennisCoachBean = context.getBean("tennisCoach", TennisCoach.class);
//        Coach swimCoachBean2 = new SportConfig().swimCoach();
        SwimCoach swimCoach = new SwimCoach(new HappyFortuneService());
        System.out.println(swimCoach);
        //A BIG NO BELOW
//        System.out.printf("Bean method always returns the bean: %s\n", swimCoachBean == swimCoachBean2 ? "yes" : "no");
//        System.out.println(coachBean.getDailyWorkout());
//        System.out.println(coachBean.getFortune());
        System.out.println(swimCoachBean);
//        System.out.println(tennisCoachBean);
//        System.out.println(new TennisCoach(new RandomFortuneService(), "email@gmail.com", "tenniss"));
//        System.out.printf("Football coach is null: %s\n", coachBean.getFootballCoach() == null ? "yes" : "no");
        context.close();
    }
}
