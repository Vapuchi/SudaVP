package com.example.prueba2.service

import com.example.prueba2.model.Conference
import com.example.prueba2.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ConferenceService {
    @Autowired
lateinit var conferenceRepository:ConferenceRepository

fun list():List<Conference>{
return conferenceRepository.findAll()
}
    fun save(conference: Conference):Conference{
    return conferenceRepository.save(conference)
    }

fun update (conference: Conference):Conference{
try {
    conferenceRepository.findById(conference.id)
            ?:throw Exception("id no existe")
return conferenceRepository.save(conference)
    }
catch (ex:Exception){
throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
}
}


}