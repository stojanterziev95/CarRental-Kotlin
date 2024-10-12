package com.example.kotlin_demo_project.jwt.security

import com.example.kotlin_demo_project.jwt.models.User
import com.example.kotlin_demo_project.jwt.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(private val userRepository: UserRepository) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user: User? = userRepository.findByUsername(username)
        return user ?: throw UsernameNotFoundException("User not found")
    }
}