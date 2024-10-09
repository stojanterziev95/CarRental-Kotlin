package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Customer
import com.example.kotlin_demo_project.repositories.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) {

    fun findAll(): List<Customer> = customerRepository.findAll()

    fun findById(id: Long): Customer? = customerRepository.findById(id).orElse(null)

    fun findByEmail(email: String): Customer? = customerRepository.findByEmail(email)

    fun save(customer: Customer): Customer = customerRepository.save(customer)

    fun deleteById(id: Long) = customerRepository.deleteById(id)
}
