package com.twcrone.spacemines.mine

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class MineFieldController {

    @GetMapping("/", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getGame(): ResponseEntity<List<MineFieldRep>> {
        val results = listOf(MineFieldRep("TEST", 3,3,3,1,1, "Easy"))
        return ResponseEntity(results, HttpStatus.OK)
    }

}