package com.example.kotlin_demo_project.jwt.repository

import com.example.kotlin_demo_project.jwt.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}