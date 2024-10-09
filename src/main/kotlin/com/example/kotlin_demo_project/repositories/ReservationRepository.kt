package com.example.kotlin_demo_project.repositories

import com.example.kotlin_demo_project.models.Customer
import com.example.kotlin_demo_project.models.Reservation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservationRepository : JpaRepository<Reservation, Long> {
    fun findByCustomer(customer: Customer): List<Reservation>
}