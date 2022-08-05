package com.example.assessment.model

data class Response(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)