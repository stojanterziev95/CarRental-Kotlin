package com.example.kotlin_demo_project.models

import com.example.kotlin_demo_project.enums.ReservationStatus
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "reservations")
data class Reservation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    val customer: Customer,

    @ManyToOne
    @JoinColumn(name = "car_id")
    val car: Car,

    @Column(nullable = false)
    val reservationDate: LocalDateTime,

    @Column(nullable = false)
    val pickupDate: LocalDateTime,

    @Column(nullable = false)
    val returnDate: LocalDateTime
)