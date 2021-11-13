package com.api.projeto.controller

import com.api.projeto.dto.EmailDTO
import com.api.projeto.entity.EmailEntity
import com.api.projeto.service.EmailService
import org.springframework.beans.BeanUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.kotlin.core.publisher.toMono
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/email")
class EmailController(val service: EmailService) {

    @PostMapping("/send")
    fun sendEmail(@RequestBody @Valid emailDTO: EmailDTO) : ResponseEntity<EmailEntity>{
        val emailEntity = EmailEntity()
        BeanUtils.copyProperties(emailDTO, emailEntity)
        service.saveAndSendEmail(emailEntity).toMono().subscribe()
        return ResponseEntity(emailEntity, HttpStatus.CREATED)
    }
}