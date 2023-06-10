package com.example.room.retrofit

data class ImageResponse(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)