package com.example.kotlin_demo_project.DTO

import com.example.kotlin_demo_project.enums.InsuranceType

data class InsuranceCreateDTO(
    val rentalId: Long,   // This should be here
    val type: InsuranceType,
    val cost: Double
)