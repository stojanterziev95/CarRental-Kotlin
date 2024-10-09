package com.example.kotlin_demo_project.repositories

import com.example.kotlin_demo_project.models.Location
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LocationRepository : JpaRepository<Location, Long>