package com.example.kotlin_demo_project.models

import jakarta.persistence.*

@Entity
@Table(name = "rental_agencies")
data class RentalAgency(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val address: String,

    @OneToMany(mappedBy = "rentalAgency", cascade = [CascadeType.ALL])
    val cars: List<Car> = emptyList()
)
