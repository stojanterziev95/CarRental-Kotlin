package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Employee
import com.example.kotlin_demo_project.repositories.EmployeeRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class EmployeeService(private val employeeRepository: EmployeeRepository) {

    fun findAll(): List<Employee> = employeeRepository.findAll()

    fun findById(id: Long): Employee? = employeeRepository.findById(id).orElse(null)

    fun save(employee: Employee): Employee = employeeRepository.save(employee)

    @Transactional
    fun update(id: Long, employee: Employee): Employee? {
        val existingEmployee = employeeRepository.findById(id).orElse(null) ?: return null
        val updatedEmployee = existingEmployee.copy(
            name = employee.name,
            role = employee.role,
            rentalAgency = employee.rentalAgency // Assuming rental agency may change
        )
        return employeeRepository.save(updatedEmployee)
    }

    fun deleteById(id: Long) = employeeRepository.deleteById(id)
}