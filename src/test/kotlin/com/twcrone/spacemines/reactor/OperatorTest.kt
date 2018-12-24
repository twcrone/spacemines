package com.twcrone.spacemines.reactor

import org.junit.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class OperatorTest {

  @Test
  fun `map`() {
    Flux.range(1, 5)
        .map { i -> i * 10 }
        .subscribe(System.out::println)
  }

  @Test
  fun `flat map`() {
    Flux.range(1, 5)
        .flatMap { i -> Flux.range(i * 10, 2) }
        .subscribe(System.out::println)
  }

  @Test
  fun `flat map many`() {
    Mono.just(3)
        .flatMapMany { i -> Flux.range(1, i) }
        .subscribe(System.out::println)
  }
}