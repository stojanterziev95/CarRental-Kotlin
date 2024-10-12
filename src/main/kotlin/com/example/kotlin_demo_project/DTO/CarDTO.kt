package com.example.kotlin_demo_project.DTO

data class CarDTO(
    val id: Long,
    val licensePlate: String,
    val brand: String,
    val model: String,
    val manufactureYear: Int,
    val mileage: Int,
    val status: String,
    val rentalAgencyName: String,
    val categoryType: String
)