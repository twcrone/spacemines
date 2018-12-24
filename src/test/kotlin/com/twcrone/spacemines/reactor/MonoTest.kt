package com.twcrone.spacemines.reactor

import org.junit.Test
import reactor.core.publisher.Mono
import java.lang.RuntimeException

class MonoTest {

  @Test
  fun monoWithConsumer() {
    Mono.just("A")
        .log()
        .subscribe(System.out::println)
  }

  @Test
  fun `checked exception mono`() {
    Mono.error<Exception>(RuntimeException("BLAH"))
        .doOnError{ e -> println("Error: $e") }
        .log()
        .subscribe(System.out::println)
  }

}