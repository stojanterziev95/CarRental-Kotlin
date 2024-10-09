package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Payment
import com.example.kotlin_demo_project.repositories.PaymentRepository
import org.springframework.stereotype.Service

@Service
class PaymentService(private val paymentRepository: PaymentRepository) {

    fun findAll(): List<Payment> = paymentRepository.findAll()

    fun findById(id: Long): Payment? = paymentRepository.findById(id).orElse(null)

    fun save(payment: Payment): Payment = paymentRepository.save(payment)

    fun deleteById(id: Long) = paymentRepository.deleteById(id)
}