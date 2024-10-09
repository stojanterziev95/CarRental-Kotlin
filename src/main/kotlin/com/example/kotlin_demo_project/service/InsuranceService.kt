package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Insurance
import com.example.kotlin_demo_project.repositories.InsuranceRepository
import org.springframework.stereotype.Service

@Service
class InsuranceService(
    private val insuranceRepository: InsuranceRepository
) {
    fun findAll(): List<Insurance> = insuranceRepository.findAll()

    fun findById(id: Long): Insurance? = insuranceRepository.findById(id).orElse(null)

    fun save(insurance: Insurance): Insurance = insuranceRepository.save(insurance)

    fun deleteById(id: Long) = insuranceRepository.deleteById(id)
}