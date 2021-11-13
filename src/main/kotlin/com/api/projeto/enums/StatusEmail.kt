package com.api.projeto.enums

enum class StatusEmail {
    PROCESSING{ override fun status() = "processing" },
    SENT { override fun status() = "sent" },
    ERROR { override fun status() = "error" };

abstract fun status() : String
}