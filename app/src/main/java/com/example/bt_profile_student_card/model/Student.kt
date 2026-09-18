package com.example.bt_profile_student_card.model


data class Student(
    val id: String,
    val name: String,
    val className: String,
    val email: String,
    val gpa: Double = 0.0
)
