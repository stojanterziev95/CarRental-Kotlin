package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Customer
import com.example.kotlin_demo_project.repositories.CustomerRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) {

    fun findAll(): List<Customer> = customerRepository.findAll()

    fun findById(id: Long): Customer? = customerRepository.findById(id).orElse(null)

    fun findByEmail(email: String): Customer? = customerRepository.findByEmail(email)

    fun save(customer: Customer): Customer = customerRepository.save(customer)

    @Transactional
    fun update(id: Long, customer: Customer): Customer? {
        // Fetch the existing customer from the database
        val existingCustomer = customerRepository.findById(id).orElse(null) ?: return null

        // Create a modified copy of the existing customer
        val updatedCustomer = existingCustomer.copy(
            name = customer.name,
            email = customer.email,
            phoneNumber = customer.phoneNumber,
            // You might not want to copy rentals and reservations here as they can lead to issues.
            // Consider handling them separately if needed.
        )

        // Save the updated customer back to the database
        return customerRepository.save(updatedCustomer)
    }

    fun deleteById(id: Long) = customerRepository.deleteById(id)
}
