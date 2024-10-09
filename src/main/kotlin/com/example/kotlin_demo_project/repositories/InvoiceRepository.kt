package com.example.kotlin_demo_project.repositories

import com.example.kotlin_demo_project.models.Invoice
import com.example.kotlin_demo_project.models.Rental
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository : JpaRepository<Invoice, Long> {
    fun findByRental(rental: Rental): Invoice?
}