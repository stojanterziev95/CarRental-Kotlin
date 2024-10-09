package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Employee
import com.example.kotlin_demo_project.repositories.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(private val employeeRepository: EmployeeRepository) {

    fun findAll(): List<Employee> = employeeRepository.findAll()

    fun findById(id: Long): Employee? = employeeRepository.findById(id).orElse(null)

    fun save(employee: Employee): Employee = employeeRepository.save(employee)

    fun deleteById(id: Long) = employeeRepository.deleteById(id)
}