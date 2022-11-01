package com.luv2code.springdemo.fortuneservice;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    private List<String> fortunes = List.of("Lucky !", "Hmmm !", "Yes, Lucky !");
    private Random rnd = new Random();

    @Override
    public String getFortune() {
        return fortunes.get(rnd.nextInt(fortunes.size()));
    }
}
