package main.com.sumit.coding.topics.java8.reactive;

import reactor.core.publisher.Mono;

public class P02MonoInstances {

    public static void main(String[] args) {
        emptyMono().subscribe(System.out::println);
    }

//========================================================================================

    // Return an empty Mono
    static Mono<String> emptyMono() {
        return Mono.empty();
    }

//========================================================================================

    // Return a Mono that never emits any signal
    static Mono<String> monoWithNoSignal() {
        return Mono.never();
    }

//========================================================================================

    // Return a Mono that contains a "foo" value
    Mono<String> fooMono() {
        return Mono.just("foo");
    }

//========================================================================================

    // Create a Mono that emits an IllegalStateException
    Mono<String> errorMono() {
        return Mono.error(new IllegalStateException());
    }
}
