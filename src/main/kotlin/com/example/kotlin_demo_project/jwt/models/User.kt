package com.example.kotlin_demo_project.jwt.models

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


@Entity
@Table(name = "users") // Ensure correct table name in the DB
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "username", unique = true)
    private val username: String, // Directly use `username` without a separate public property

    @Column(name = "password")
    private val password: String, // Directly use `password` without a separate public property

    @ManyToMany(fetch = FetchType.EAGER) // Eager loading for roles
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    val roles: List<Role> = emptyList()
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return roles.map { GrantedAuthority { it.name } }
    }

    override fun getPassword(): String = password

    override fun getUsername(): String = username

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}