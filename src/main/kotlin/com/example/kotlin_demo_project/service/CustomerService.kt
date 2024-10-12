package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.DTO.CustomerCreateDTO
import com.example.kotlin_demo_project.DTO.CustomerDTO
import com.example.kotlin_demo_project.MapperInterface.CustomerMapper
import com.example.kotlin_demo_project.models.Customer
import com.example.kotlin_demo_project.repositories.CustomerRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val customerMapper: CustomerMapper
) {

    fun findAll(): List<CustomerDTO> =
        customerRepository.findAll().map { customerMapper.toDTO(it) }

    fun findById(id: Long): CustomerDTO? =
        customerRepository.findById(id).map { customerMapper.toDTO(it) }.orElse(null)

    fun findByEmail(email: String): CustomerDTO? =
        customerRepository.findByEmail(email)?.let { customerMapper.toDTO(it) }

    fun save(customerCreateDTO: CustomerCreateDTO): CustomerDTO {
        val customer = customerMapper.toModel(customerCreateDTO)
        return customerMapper.toDTO(customerRepository.save(customer))
    }

    @Transactional
    fun update(id: Long, customerCreateDTO: CustomerCreateDTO): CustomerDTO? {
        val existingCustomer = customerRepository.findById(id).orElse(null) ?: return null

        val updatedCustomer = existingCustomer.copy(
            name = customerCreateDTO.name,
            email = customerCreateDTO.email,
            phoneNumber = customerCreateDTO.phoneNumber
        )

        return customerMapper.toDTO(customerRepository.save(updatedCustomer))
    }

    fun deleteById(id: Long) = customerRepository.deleteById(id)
}
