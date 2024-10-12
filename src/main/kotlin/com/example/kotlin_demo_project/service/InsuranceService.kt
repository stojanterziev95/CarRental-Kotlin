package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.DTO.InsuranceCreateDTO
import com.example.kotlin_demo_project.DTO.InsuranceDTO
import com.example.kotlin_demo_project.MapperInterface.InsuranceMapper
import com.example.kotlin_demo_project.models.Insurance
import com.example.kotlin_demo_project.repositories.InsuranceRepository
import com.example.kotlin_demo_project.repositories.RentalRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class InsuranceService(
    private val insuranceRepository: InsuranceRepository,
    private val rentalRepository: RentalRepository,
    private val insuranceMapper: InsuranceMapper
) {
    fun findAll(): List<InsuranceDTO> =
        insuranceRepository.findAll().map { insuranceMapper.toInsuranceDTO(it) }

    fun findById(id: Long): InsuranceDTO? =
        insuranceRepository.findById(id).orElse(null)?.let { insuranceMapper.toInsuranceDTO(it) }

    fun save(insuranceCreateDTO: InsuranceCreateDTO): InsuranceDTO {
        val rental = rentalRepository.findById(insuranceCreateDTO.rentalId)
            .orElseThrow { IllegalArgumentException("Rental not found") }
        val insurance = insuranceMapper.toInsurance(insuranceCreateDTO, rental)
        val savedInsurance = insuranceRepository.save(insurance)
        return insuranceMapper.toInsuranceDTO(savedInsurance)
    }

    @Transactional
    fun update(id: Long, insuranceCreateDTO: InsuranceCreateDTO): InsuranceDTO? {
        val existingInsurance = insuranceRepository.findById(id).orElse(null) ?: return null
        val rental = rentalRepository.findById(insuranceCreateDTO.rentalId)
            .orElseThrow { IllegalArgumentException("Rental not found") }

        val updatedInsurance = existingInsurance.copy(
            type = insuranceCreateDTO.type,
            cost = insuranceCreateDTO.cost,
            rental = rental
        )
        val savedInsurance = insuranceRepository.save(updatedInsurance)
        return insuranceMapper.toInsuranceDTO(savedInsurance)
    }

    fun deleteById(id: Long) = insuranceRepository.deleteById(id)
}