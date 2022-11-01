package com.luv2code.springdemo.coaches;


import com.luv2code.springdemo.fortuneservice.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope(scopeName = "prototype")
public class TennisCoach implements Coach {
    //field injection
//    @Autowired
    private FortuneService fortuneService;
    private String email;
    private String sports;

// constructor injection
//    @Autowired //can be commented out if this is the only one constructor requiring FortuneService as a parameter
    public TennisCoach(
            @Qualifier("fileRandomFortuneService") FortuneService fortuneService,
            @Value("${default.email}") String email,
            @Value("${default.sports}") String sports) {
        System.out.println("Inside parametrized constructor");
        this.fortuneService = fortuneService;
//        this.email = email;
//        this.sports = sports;
    }

//
//    public TennisCoach() {
//        System.out.println("Inside no-arg constructor");
//    }

    @Override
    public String getDailyWorkout() {
        return "Play tennis, of course";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }

    //setter injection
    //any method name is acceptable as long as the method accepts parameter types which have suitable beans
//    @Autowired
//    @Qualifier("randomFortuneService")
//    public void setFortuneService(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//        System.out.println("FortuneService injected");
//    }


    @Override
    public String toString() {
        return "TennisCoach{" +
                "email='" + email + '\'' +
                ", sports='" + sports + '\'' +
                ", dailyWorkout='" + getDailyWorkout() + '\'' +
                ", fortune='" + getFortune() + '\'' +
                '}';
    }

    @PostConstruct
    public void init() {
        System.out.println("Post: tennis coach bean instantiated");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Pre: tennis coach bean destroyed");
    }
}
