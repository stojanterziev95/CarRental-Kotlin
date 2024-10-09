package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Location
import com.example.kotlin_demo_project.repositories.LocationRepository
import org.springframework.stereotype.Service

@Service
class LocationService(private val locationRepository: LocationRepository) {

    fun findAll(): List<Location> = locationRepository.findAll()

    fun findById(id: Long): Location? = locationRepository.findById(id).orElse(null)

    fun save(location: Location): Location = locationRepository.save(location)

    fun deleteById(id: Long) = locationRepository.deleteById(id)
}