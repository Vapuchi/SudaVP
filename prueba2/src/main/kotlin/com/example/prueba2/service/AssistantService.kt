package com.example.prueba2.service

import com.example.prueba2.model.Assistant
import com.example.prueba2.repository.AssistantRepository
import com.example.prueba2.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AssistantService {
    @Autowired
lateinit var assistantRepository:AssistantRepository
    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

fun list():List<Assistant>{
return assistantRepository.findAll()
}
    fun save (assistant: Assistant): Assistant? {
        try {

            val responseAssistant=assistantRepository.save(assistant)


            val totalAssistant=getTotalAssistant(assistant.conferenceId)


            val responseConference=conferenceRepository.findById(assistant.conferenceId)
                    ?: throw Exception ("Id de conference no exist")
            //
            conferenceRepository.save(responseConference.apply { assistants=totalAssistant })

            return responseAssistant
        } catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message,ex)
        }
    }

    fun getTotalAssistant(conferenceId: Long? ): Double? {
        return assistantRepository.getTotalAssistant(conferenceId)
    }

fun update (assistant: Assistant):Assistant{
try {
    assistantRepository.findById(assistant.id)
            ?:throw Exception("id no existe")
return assistantRepository.save(assistant)
    }
catch (ex:Exception){
throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
}
}


}
