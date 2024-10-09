package com.example.kotlin_demo_project.models

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "invoices")
data class Invoice(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "rental_id")
    val rental: Rental,

    @Column(nullable = false)
    val issueDate: LocalDateTime,

    @Column(nullable = false)
    val totalAmount: Double
)
