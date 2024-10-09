package com.example.kotlin_demo_project.models

import jakarta.persistence.*

@Entity
@Table(name = "locations")
data class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val address: String,

    @Column(nullable = false)
    val city: String,

    @Column(nullable = false)
    val country: String,

    @OneToMany(mappedBy = "pickupLocation", cascade = [CascadeType.ALL])
    val pickups: List<Rental> = emptyList(),

    @OneToMany(mappedBy = "dropoffLocation", cascade = [CascadeType.ALL])
    val dropoffs: List<Rental> = emptyList()
)

