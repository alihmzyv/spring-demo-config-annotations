package com.luv2code.springdemo.coaches;

import com.luv2code.springdemo.fortuneservice.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
    private FortuneService fortuneService;
    @Value("${default.email}")
    private String emailAddress;
    @Value("${default.sports}")
    private String sport;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim, of course";
    }

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String toString() {
        return "SwimCoach{" +
                "emailAddress='" + emailAddress + '\'' +
                ", sport='" + sport + '\'' +
                ", dailyWorkout='" + getDailyWorkout() + '\'' +
                ", fortune='" + getFortune() + '\'' +
                '}';
    }
}
