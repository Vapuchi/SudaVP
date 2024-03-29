package com.example.prueba2.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.jetbrains.annotations.NotNull

@Entity
@Table(name="assistant")
class Assistant {
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
@Column(updatable =false)

var id: Long? =null

    @NotNull()
    var fullname: String?= null
    var role: String?= null
    var age: Int? = null
    @Column(name="conference_id")
    var conferenceId: Long? = null

}
