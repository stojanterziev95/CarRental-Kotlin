package com.example.kotlin_demo_project.repositories

import com.example.kotlin_demo_project.models.RentalAgency
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RentalAgencyRepository : JpaRepository<RentalAgency, Long>