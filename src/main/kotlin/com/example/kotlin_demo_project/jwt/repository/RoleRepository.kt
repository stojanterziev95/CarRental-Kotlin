package com.example.kotlin_demo_project.jwt.repository

import com.example.kotlin_demo_project.jwt.models.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Long> {
    fun findByName(name: String): Role?
}