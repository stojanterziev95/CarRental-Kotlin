package com.example.kotlin_demo_project.models

import com.example.kotlin_demo_project.enums.CarCategory
import jakarta.persistence.*

@Entity
@Table(name = "categories")
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val type: CarCategory,  // e.g., "SUV", "Sedan"

    @Column(nullable = false)
    val pricePerDay: Double,

    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL])
    val cars: List<Car> = emptyList()
) {
    constructor() : this() {

    }
}