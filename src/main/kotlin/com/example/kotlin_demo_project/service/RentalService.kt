package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Rental
import com.example.kotlin_demo_project.repositories.RentalRepository
import org.springframework.stereotype.Service

@Service
class RentalService(private val rentalRepository: RentalRepository) {

    fun findAll(): List<Rental> = rentalRepository.findAll()

    fun findById(id: Long): Rental? = rentalRepository.findById(id).orElse(null)

    fun save(rental: Rental): Rental = rentalRepository.save(rental)

    fun deleteById(id: Long) = rentalRepository.deleteById(id)
}