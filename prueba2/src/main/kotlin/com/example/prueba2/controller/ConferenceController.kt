package com.example.prueba2.controller

import com.example.prueba2.model.Conference
import com.example.prueba2.service.ConferenceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/conference")
class ConferenceController {
    @Autowired
    lateinit var conferenceService: ConferenceService

    @GetMapping
    fun list():ResponseEntity<*>{
        return ResponseEntity(conferenceService.list(), HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody conference: Conference): Conference{
        return conferenceService.save(conference)}

    @PutMapping
    fun update (@RequestBody conference: Conference):ResponseEntity<Conference>{
        return ResponseEntity(conferenceService.update(conference), HttpStatus.OK)
    }



}