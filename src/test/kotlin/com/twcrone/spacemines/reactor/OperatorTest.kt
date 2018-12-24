package com.twcrone.spacemines.reactor

import org.junit.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

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

  @Test
  fun `concat and merge`() {
    val oneToFive = Flux.range(1, 5).delayElements(Duration.ofMillis(200))
    val sixToTen = Flux.range(6, 5).delayElements(Duration.ofMillis(400))

    Flux.merge(oneToFive, sixToTen)
        .subscribe(System.out::println)

    //Thread.sleep(4000)
  }

  @Test
  fun `zip`() {
    val oneToFive = Flux.range(1, 5)
    val sixToTen = Flux.range(6, 5)

    oneToFive.zipWith(sixToTen)
        .log()
        .subscribe()
  }
}