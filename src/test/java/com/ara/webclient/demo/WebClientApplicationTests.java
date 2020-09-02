package com.ara.webclient.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@SpringBootTest(classes = WebClientApplication.class)
@ContextConfiguration
class WebClientApplicationTests {

    @Test
    void contextLoads() {

        Flux<Person> personFlux = WebClient.create()
                .get()
                .uri("http:localhost:8080")
                .retrieve()
                .bodyToFlux(Person.class);

        personFlux.subscribe(System.out::print);
    }
}
