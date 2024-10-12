package com.example.kotlin_demo_project.models

import com.example.kotlin_demo_project.enums.CarCategory
import com.example.kotlin_demo_project.enums.CarStatus
import jakarta.persistence.*

@Entity
@Table(name = "cars")
data class Car(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val licensePlate: String,

    @Column(nullable = false)
    val brand: String,

    @Column(nullable = false)
    val model: String,

    @Column(name = "manufacture_year", nullable = false)
    val manufactureYear: Int,

    @Column(nullable = false)
    val mileage: Int,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val status: CarStatus,

    @ManyToOne
    @JoinColumn(name = "rental_agency_id")
    val rentalAgency: RentalAgency,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: Category,  // New relationship to Category

    @OneToMany(mappedBy = "car", cascade = [CascadeType.ALL])
    val rentals: List<Rental> = emptyList()
)
