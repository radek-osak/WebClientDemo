package com.ara.webclient.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;


@RestController
public class ReactiveRestApiController {

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Person> getSomething() {
        return getData();
    }

    @EventListener(ApplicationReadyEvent.class)
    private Flux<Person> getData() {
        return Flux.just(
                new Person("First Name 1", "Last Name 1", 31),
                new Person("First Name 2", "Last Name 2", 32),
                new Person("First Name 3", "Last Name 3", 33),
                new Person("First Name 4", "Last Name 4", 34),
                new Person("First Name 5", "Last Name 5", 35),
                new Person("First Name 6", "Last Name 6", 36),
                new Person("First Name 7", "Last Name 7", 37),
                new Person("First Name 8", "Last Name 8", 38)
        ).delayElements(Duration.ofSeconds(1));
    }
}
