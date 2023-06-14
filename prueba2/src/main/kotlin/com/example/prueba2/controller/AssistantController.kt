package com.example.prueba2.controller

import com.example.prueba2.model.Assistant
import com.example.prueba2.service.AssistantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/assistant")
class AssistantController {
    @Autowired
    lateinit var assistantService: AssistantService

    @GetMapping
    fun list():ResponseEntity<*>{
        return ResponseEntity(assistantService.list(), HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody assistant: Assistant): ResponseEntity<Assistant>{
        return ResponseEntity(assistantService.save(assistant), HttpStatus.OK)    }

    @PutMapping
    fun update (@RequestBody assistant: Assistant):ResponseEntity<Assistant>{
        return ResponseEntity(assistantService.update(assistant), HttpStatus.OK)
    }



}