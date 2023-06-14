package com.example.prueba2.repository

import com.example.prueba2.model.Conference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface ConferenceRepository: JpaRepository<Conference, Long> {
fun findById(id: Long?):Conference?
//@Query(nativeQuery = true)


}