package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.DTO.CreateEmployeeDTO
import com.example.kotlin_demo_project.DTO.EmployeeDTO
import com.example.kotlin_demo_project.MapperInterface.EmployeeMapper
import com.example.kotlin_demo_project.models.Employee
import com.example.kotlin_demo_project.repositories.EmployeeRepository
import com.example.kotlin_demo_project.repositories.RentalAgencyRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
    private val rentalAgencyRepository: RentalAgencyRepository
) {
    private val employeeMapper = EmployeeMapper.INSTANCE

    fun findAll(): List<EmployeeDTO> =
        employeeRepository.findAll().map { employeeMapper.toEmployeeDTO(it) }

    fun findById(id: Long): EmployeeDTO? =
        employeeRepository.findById(id).orElse(null)?.let { employeeMapper.toEmployeeDTO(it) }

    fun save(createEmployeeDTO: CreateEmployeeDTO): EmployeeDTO {
        val employee = employeeMapper.toEmployee(createEmployeeDTO)
        val rentalAgency = rentalAgencyRepository.findById(createEmployeeDTO.rentalAgencyId)
            .orElseThrow { IllegalArgumentException("Invalid Rental Agency ID") }
        employee.rentalAgency = rentalAgency
        return employeeMapper.toEmployeeDTO(employeeRepository.save(employee))
    }

    @Transactional
    fun update(id: Long, createEmployeeDTO: CreateEmployeeDTO): EmployeeDTO? {
        val existingEmployee = employeeRepository.findById(id).orElse(null) ?: return null
        val rentalAgency = rentalAgencyRepository.findById(createEmployeeDTO.rentalAgencyId)
            .orElseThrow { IllegalArgumentException("Invalid Rental Agency ID") }
        val updatedEmployee = existingEmployee.copy(
            name = createEmployeeDTO.name,
            role = createEmployeeDTO.role,
            rentalAgency = rentalAgency
        )
        return employeeMapper.toEmployeeDTO(employeeRepository.save(updatedEmployee))
    }

    fun deleteById(id: Long) = employeeRepository.deleteById(id)
}
