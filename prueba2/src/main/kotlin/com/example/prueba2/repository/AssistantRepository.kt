package com.example.prueba2.repository

import com.example.prueba2.model.Assistant
import com.example.prueba2.model.Conference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface AssistantRepository: JpaRepository<Assistant, Long> {
fun findById(id: Long?):Assistant?
@Query(nativeQuery = true)
fun getTotalAssistant(@Param("conferenceId") conferenceId: Long?): Double?



}