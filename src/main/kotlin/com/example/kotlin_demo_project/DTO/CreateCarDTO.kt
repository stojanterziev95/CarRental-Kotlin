package com.example.kotlin_demo_project.DTO

data class CreateCarDTO(
    val licensePlate: String,
    val brand: String,
    val model: String,
    val manufactureYear: Int,
    val mileage: Int,
    val status: String,
    val rentalAgencyId: Long,
    val categoryId: Long
)