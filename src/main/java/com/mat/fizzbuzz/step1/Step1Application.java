package com.mat.fizzbuzz.step1;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class Step1Application implements CommandLineRunner {

    private FizzBuzzService fizzBuzzService;

    @Autowired
    public void setFizzBuzzService(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("start interval = ");
        String startInterval=null;
        String endInterval=null;

        if (scanner.hasNext()) {
            startInterval = scanner.nextLine();
            System.out.println("end interval = ");
            endInterval = scanner.nextLine();
        }
        System.out.println("startInterval = "+ startInterval);
        System.out.println("end interval = "+ endInterval);

        Arrays.stream(fizzBuzzService.transform(Integer.parseInt(startInterval), Integer.parseInt(endInterval))).forEach(System.out::println);

    }

    public static void main(String[] args) {
        SpringApplication.run(Step1Application.class, args);
    }
}
