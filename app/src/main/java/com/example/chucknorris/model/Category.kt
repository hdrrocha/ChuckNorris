package com.example.chucknorris.model

import java.util.*

data class Category(
    val categories: List<String>,
    val created_at: String,
    val icon_url: String,
    val id: String,
    val url: String,
    val value: String)