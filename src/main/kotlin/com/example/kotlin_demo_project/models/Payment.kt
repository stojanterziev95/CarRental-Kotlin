package com.example.kotlin_demo_project.models

import com.example.kotlin_demo_project.enums.PaymentMethod
import com.example.kotlin_demo_project.enums.PaymentStatus
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "payments")
data class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @OneToOne
    @JoinColumn(name = "rental_id")
    val rental: Rental,

    @Column(nullable = false)
    val amount: Double,

    @Column(nullable = false)
    val paymentDate: LocalDateTime,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val paymentMethod: PaymentMethod
)


