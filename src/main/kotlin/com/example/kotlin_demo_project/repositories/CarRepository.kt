package com.example.kotlin_demo_project.repositories

import com.example.kotlin_demo_project.models.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarRepository : JpaRepository<Car, Long> {
    fun findByLicensePlate(licensePlate: String): Car?
    fun findAvailableCars(): List<Car>
}