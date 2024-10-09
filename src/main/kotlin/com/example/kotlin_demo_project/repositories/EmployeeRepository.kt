package com.example.kotlin_demo_project.repositories

import com.example.kotlin_demo_project.models.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<Employee, Long>