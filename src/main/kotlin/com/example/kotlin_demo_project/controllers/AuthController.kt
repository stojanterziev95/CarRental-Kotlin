package com.example.kotlin_demo_project.controllers

import com.example.kotlin_demo_project.DTO.AuthRequest
import com.example.kotlin_demo_project.DTO.JwtResponse
import com.example.kotlin_demo_project.jwt.models.User
import com.example.kotlin_demo_project.jwt.repository.UserRepository
import com.example.kotlin_demo_project.jwt.security.JwtUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val jwtUtil: JwtUtil,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @PostMapping("/authenticate")
    fun authenticate(@RequestBody authRequest: AuthRequest): ResponseEntity<JwtResponse> {
        try {
            val authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(authRequest.username, authRequest.password)
            )
            SecurityContextHolder.getContext().authentication = authentication

            val jwt = jwtUtil.generateToken(authRequest.username)
            return ResponseEntity.ok(JwtResponse(jwt))
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @PostMapping("/register")
    fun register(@RequestBody user: User): ResponseEntity<String> {
        // Perform necessary checks, e.g., if username already exists
        userRepository.save(user.copy(password = passwordEncoder.encode(user.password)))
        return ResponseEntity.ok("User registered successfully!")
    }
}
