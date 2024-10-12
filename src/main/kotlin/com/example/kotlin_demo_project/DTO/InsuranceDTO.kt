package com.example.kotlin_demo_project.DTO

import com.example.kotlin_demo_project.enums.InsuranceType

data class InsuranceDTO(
    val id: Long,
    val rentalId: Long,   // This should also be here
    val type: InsuranceType,
    val cost: Double
)