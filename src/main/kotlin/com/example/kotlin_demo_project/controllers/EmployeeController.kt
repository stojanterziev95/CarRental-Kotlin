package com.example.kotlin_demo_project.controllers

import com.example.kotlin_demo_project.DTO.CreateEmployeeDTO
import com.example.kotlin_demo_project.DTO.EmployeeDTO
import com.example.kotlin_demo_project.models.Employee
import com.example.kotlin_demo_project.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/employees")
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping
    fun getAllEmployees(): List<EmployeeDTO> = employeeService.findAll()

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Long): ResponseEntity<EmployeeDTO> {
        val employee = employeeService.findById(id)
        return employee?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createEmployee(@RequestBody createEmployeeDTO: CreateEmployeeDTO): EmployeeDTO =
        employeeService.save(createEmployeeDTO)

    @PutMapping("/{id}")
    fun updateEmployee(
        @PathVariable id: Long,
        @RequestBody createEmployeeDTO: CreateEmployeeDTO
    ): ResponseEntity<EmployeeDTO> {
        val updatedEmployee = employeeService.update(id, createEmployeeDTO)
        return updatedEmployee?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: Long): ResponseEntity<Void> {
        employeeService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}