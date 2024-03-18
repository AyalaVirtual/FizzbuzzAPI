package com.example.fizzbuzzapi.seed;

import com.example.fizzbuzzapi.model.Fizzbuzz;
import com.example.fizzbuzzapi.repository.FizzbuzzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Random;


@Component
public class SeedData implements CommandLineRunner {
    private final FizzbuzzRepository fizzbuzzRepository;


    @Autowired
    public SeedData(FizzbuzzRepository fizzbuzzRepository) {
        this.fizzbuzzRepository = fizzbuzzRepository;
    }


    private static final String[] userAgents = {
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.111 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36"
    };

    // This generates a random number
    private static final Random randomNum = new Random();

    // This generates a random index between 0 and the length of the userAgents array - 1
    private static int randomIndex = randomNum.nextInt(userAgents.length);

    // This generates a random user agent
    public static <randomIndex> String generateRandomUserAgent() {
        return userAgents[randomIndex];
    }

    String randomUserAgent = generateRandomUserAgent();

    // This generates a random date and stores it in a variable
    Date randomDate = new Date();


    @Override
    public void run(String... args) throws Exception {

        Fizzbuzz fizzbuzz1 = new Fizzbuzz();
        fizzbuzz1.setUserAgent(randomUserAgent);
        fizzbuzz1.setCreationDate(randomDate);
        fizzbuzz1.setMessage("Java beats all other programming languages.");
        fizzbuzzRepository.save(fizzbuzz1);

        Fizzbuzz fizzbuzz2 = new Fizzbuzz();
        fizzbuzz2.setUserAgent(randomUserAgent);
        fizzbuzz2.setCreationDate(randomDate);
        fizzbuzz2.setMessage("The Spring framework is versatile.");
        fizzbuzzRepository.save(fizzbuzz2);

        Fizzbuzz fizzbuzz3 = new Fizzbuzz();
        fizzbuzz3.setUserAgent(randomUserAgent);
        fizzbuzz3.setCreationDate(randomDate);
        fizzbuzz3.setMessage("React is the best front end framework.");
        fizzbuzzRepository.save(fizzbuzz3);

        Fizzbuzz fizzbuzz4 = new Fizzbuzz();
        fizzbuzz4.setUserAgent(randomUserAgent);
        fizzbuzz4.setCreationDate(randomDate);
        fizzbuzz4.setMessage("PostgreSQL and H2 database are my favorites.");
        fizzbuzzRepository.save(fizzbuzz4);

        Fizzbuzz fizzbuzz5 = new Fizzbuzz();
        fizzbuzz5.setUserAgent(randomUserAgent);
        fizzbuzz5.setCreationDate(randomDate);
        fizzbuzz5.setMessage("Ruby on Rails is interesting and I'd like to learn it.");
        fizzbuzzRepository.save(fizzbuzz5);
    }
}
