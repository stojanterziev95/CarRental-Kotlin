package com.example.kotlin_demo_project.models

import jakarta.persistence.*

@Entity
@Table(name = "customers")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val phoneNumber: String,

    @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL])
    val rentals: List<Rental> = emptyList(),

    @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL])
    val reservations: List<Reservation> = emptyList()
) {
    constructor() : this() {

    }
}
