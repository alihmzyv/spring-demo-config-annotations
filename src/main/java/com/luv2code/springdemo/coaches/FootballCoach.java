package com.luv2code.springdemo.coaches;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Play football, of course";
    }

    @Override
    public String getFortune() {
        return null;
    }
}
