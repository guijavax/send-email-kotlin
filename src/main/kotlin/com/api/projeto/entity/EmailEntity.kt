package com.api.projeto.entity

import com.api.projeto.enums.StatusEmail
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Table(name ="message")
@Entity
data class EmailEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val idEmail : UUID = UUID.randomUUID(),

    var ownerRef : String = "",
    var emailFrom : String = "",
    var emailTo : String = "",
    var subject : String  = "",

    @Column(columnDefinition = "TEXT")
    var text : String = "",

    var sendDateEmail : LocalDateTime = LocalDateTime.now(),

    var statusEmail: String = StatusEmail.PROCESSING.status()
)