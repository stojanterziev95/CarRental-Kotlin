package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Insurance
import com.example.kotlin_demo_project.repositories.InsuranceRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class InsuranceService(
    private val insuranceRepository: InsuranceRepository
) {
    fun findAll(): List<Insurance> = insuranceRepository.findAll()

    fun findById(id: Long): Insurance? = insuranceRepository.findById(id).orElse(null)

    fun save(insurance: Insurance): Insurance = insuranceRepository.save(insurance)

    @Transactional
    fun update(id: Long, insurance: Insurance): Insurance? {
        val existingInsurance = insuranceRepository.findById(id).orElse(null) ?: return null
        val updatedInsurance = existingInsurance.copy(
            type = insurance.type,
            cost = insurance.cost,
            rental = insurance.rental // Assuming rental may change
        )
        return insuranceRepository.save(updatedInsurance)
    }

    fun deleteById(id: Long) = insuranceRepository.deleteById(id)
}