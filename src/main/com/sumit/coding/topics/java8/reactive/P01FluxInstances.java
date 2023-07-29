package main.com.sumit.coding.topics.java8.reactive;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

/*
 * https://musigma.blog/2016/11/21/reactor.html
 * */
public class P01FluxInstances {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        counter().subscribe(System.out::println);
    }

//========================================================================================

    // Return an empty Flux
    static Flux<String> emptyFlux() {
        return Flux.empty();
    }

//========================================================================================

    // Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
    static Flux<String> fooBarFluxFromValues() {
        return Flux.just("foo", "bar");
    }

//========================================================================================

    // TODO Create a Flux from a List that contains 2 values "foo" and "bar"
    static Flux<String> fooBarFluxFromList() {
        return Flux.fromIterable(List.of("foo", "bar")).onErrorReturn("Some error occurerd");
    }

//========================================================================================

    // TODO Create a Flux that emits an IllegalStateException
    static Flux<String> errorFlux() throws InstantiationException, IllegalAccessException {
        return Flux.error(new IllegalStateException());
    }

//========================================================================================

    // TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
    static Flux<Long> counter() {
        return Flux.interval(Duration.ofMillis(100)).take(10);
    }

}
