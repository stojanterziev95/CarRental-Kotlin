package com.example.kotlin_demo_project.repositories

import com.example.kotlin_demo_project.models.Customer
import com.example.kotlin_demo_project.models.Rental
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RentalRepository : JpaRepository<Rental, Long> {
    fun findByCustomer(customer: Customer): List<Rental>
}