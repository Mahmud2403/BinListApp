package com.example.binlistapp.base

import com.example.binlistapp.R


enum class HttpStatusCode(val code: Int, val userMessage: Int) {
    Unknown(-1, R.string.http_status_unknown_developer_message),

    // Client Errors
    LimitService(429, R.string.http_status_429_developer_message),
    EmptyData(301, R.string.http_status_301_developer_message),
    IncorrectData(400, R.string.http_status_400_developer_message)
}
