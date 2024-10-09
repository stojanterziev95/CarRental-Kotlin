package com.example.kotlin_demo_project.models

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "rentals")
data class Rental(
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
    val rentalDate: LocalDateTime,

    @Column(nullable = false)
    val returnDate: LocalDateTime? = null,

    @ManyToOne
    @JoinColumn(name = "pickup_location_id")
    val pickupLocation: Location,

    @ManyToOne
    @JoinColumn(name = "dropoff_location_id")
    val dropoffLocation: Location,

    @OneToOne(mappedBy = "rental", cascade = [CascadeType.ALL])
    val payment: Payment? = null,

    @OneToOne(mappedBy = "rental", cascade = [CascadeType.ALL])
    val invoice: Invoice? = null
)
