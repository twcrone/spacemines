package com.twcrone.spacemines.reactor

import org.junit.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.lang.RuntimeException
import java.time.Duration

class FluxTest {

  @Test
  fun `first flux`() {
    Flux.fromIterable(listOf("A", "B", "C"))
        .log()
        .subscribe(System.out::println)
  }

  @Test
  fun `flux from range`() {
    Flux.range(10, 5)
        .log()
        .subscribe(null, null, null) { s ->
          s.request(3)
        }
  }

  @Test
  fun `flux from interval`() {
    Flux.interval(Duration.ofMillis(50))
        .log()
        .take(3)
        .subscribe()
    Thread.sleep(500)
  }
}