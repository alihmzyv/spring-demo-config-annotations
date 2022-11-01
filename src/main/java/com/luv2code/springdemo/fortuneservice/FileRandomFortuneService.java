package com.luv2code.springdemo.fortuneservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

@Component
public class FileRandomFortuneService implements FortuneService {

    private List<String> fortunes;
    private static Random rnd = new Random();
    private String fileName;

    @Autowired
    public FileRandomFortuneService(@Value("${default.fortunes.file}") String fileName) {
        this.fileName = fileName;
    }

    @PostConstruct
    public void init() {
        try {
            this.fortunes = Files.readAllLines(Path.of(String.format("src/main/resources/%s", fileName)));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getFortune() {
        return fortunes.get(rnd.nextInt(fortunes.size()));
    }
}
