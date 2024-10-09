package com.example.kotlin_demo_project.models

import com.example.kotlin_demo_project.enums.InsuranceType

data class Insurance(
    val id: Long,
    val rental: Rental,   // One-to-one with Rental
    val type: InsuranceType,
    val cost: Double
)