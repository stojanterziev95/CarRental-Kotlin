package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Rental
import com.example.kotlin_demo_project.repositories.RentalRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class RentalService(private val rentalRepository: RentalRepository) {

    fun findAll(): List<Rental> = rentalRepository.findAll()

    fun findById(id: Long): Rental? = rentalRepository.findById(id).orElse(null)

    fun save(rental: Rental): Rental = rentalRepository.save(rental)

    @Transactional
    fun update(id: Long, rental: Rental): Rental? {
        val existingRental = rentalRepository.findById(id).orElse(null) ?: return null
        val updatedRental = existingRental.copy(
            customer = rental.customer,
            car = rental.car,
            rentalDate = rental.rentalDate,
            returnDate = rental.returnDate,
            pickupLocation = rental.pickupLocation,
            dropoffLocation = rental.dropoffLocation
            // Assuming payment and invoice relationship updates are handled separately if needed
        )
        return rentalRepository.save(updatedRental)
    }

    fun deleteById(id: Long) = rentalRepository.deleteById(id)
}