package com.api.projeto.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class EmailDTO(

    @JsonProperty("owner_ref")
    @field:NotBlank
    val ownerRef : String = "",

    @JsonProperty("email_to")
    @field:NotBlank
    @field:Email
    val emailTo : String = "",

    @JsonProperty("email_from")
    @field:NotBlank
    @field:Email
    val emailFrom : String = "",

    @field:NotBlank
    val subject : String = "",

    @field:NotBlank
    val text : String = ""
)