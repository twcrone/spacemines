package com.twcrone.spacemines.reactor

import org.junit.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.lang.RuntimeException

class FluxTest {

  @Test
  fun `first flux`() {
    Flux.fromIterable(listOf("A", "B", "C"))
        .log()
        .subscribe(System.out::println)
  }

}