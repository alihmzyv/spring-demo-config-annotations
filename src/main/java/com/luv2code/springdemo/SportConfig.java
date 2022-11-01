package com.luv2code.springdemo;

import com.luv2code.springdemo.coaches.Coach;
import com.luv2code.springdemo.coaches.SwimCoach;
import com.luv2code.springdemo.fortuneservice.FileRandomFortuneService;
import com.luv2code.springdemo.fortuneservice.FortuneService;
import com.luv2code.springdemo.fortuneservice.HappyFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource(value = "default.properties")
/*
from doc of @Component scan:
Either basePackageClasses or basePackages (or its alias value) may be specified to define specific packages to scan.
If specific packages are not defined, scanning will occur from the package of the class that declares this annotation.
 */
public class SportConfig {
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(fortuneService());
    }

    @Bean
    public FortuneService fortuneService() {
        return new FileRandomFortuneService("fortunes.txt");
    }
}
