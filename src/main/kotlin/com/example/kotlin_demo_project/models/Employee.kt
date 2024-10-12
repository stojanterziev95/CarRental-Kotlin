package com.example.kotlin_demo_project.models

import jakarta.persistence.*

@Entity
@Table(name = "employees")
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val role: String,

    @ManyToOne
    @JoinColumn(name = "rental_agency_id")
    var rentalAgency: RentalAgency
)