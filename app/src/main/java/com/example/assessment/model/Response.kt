package com.example.assessment.model

data class Response(
    val copyright: String? = null,
    val num_results: Int = 0,
    val results: List<Result>? = null,
    val status: String? = null
)