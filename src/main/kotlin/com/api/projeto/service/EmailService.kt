package com.api.projeto.service

import com.api.projeto.EmailRepository
import com.api.projeto.dto.EmailDTO
import com.api.projeto.entity.EmailEntity
import com.api.projeto.enums.StatusEmail
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.time.LocalDateTime

@Service
class EmailService(val sender : JavaMailSender, val emailRepository: EmailRepository) {

    fun saveAndSendEmail(emailEntity: EmailEntity){
        Mono.just(SimpleMailMessage()).subscribe{message ->
            emailEntity.sendDateEmail = LocalDateTime.now()
            message.setFrom(emailEntity.emailFrom)
            message.setTo(emailEntity.emailTo)
            message.setSubject(emailEntity.subject)
            message.setText(emailEntity.text)
            sender.send(message)
        }.toMono().doOnSuccess{
            emailEntity.statusEmail = StatusEmail.SENT.status()
            emailRepository.save(emailEntity)
        }.subscribe()
    }

}