package com.example.kotlin_demo_project.models

import com.example.kotlin_demo_project.enums.InsuranceType
import jakarta.persistence.*

@Entity
@Table(name = "insurances")
data class Insurance(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "rental_id", nullable = false)
    val rental: Rental,   // One-to-one with Rental

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val type: InsuranceType,

    @Column(nullable = false)
    val cost: Double
)