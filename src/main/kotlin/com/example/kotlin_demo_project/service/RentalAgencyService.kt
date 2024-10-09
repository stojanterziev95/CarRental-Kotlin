package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.RentalAgency
import com.example.kotlin_demo_project.repositories.RentalAgencyRepository
import org.springframework.stereotype.Service

@Service
class RentalAgencyService(private val rentalAgencyRepository: RentalAgencyRepository) {

    fun findAll(): List<RentalAgency> = rentalAgencyRepository.findAll()

    fun findById(id: Long): RentalAgency? = rentalAgencyRepository.findById(id).orElse(null)

    fun save(rentalAgency: RentalAgency): RentalAgency = rentalAgencyRepository.save(rentalAgency)

    fun deleteById(id: Long) = rentalAgencyRepository.deleteById(id)
}