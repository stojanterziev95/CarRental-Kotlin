package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Location
import com.example.kotlin_demo_project.repositories.LocationRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class LocationService(private val locationRepository: LocationRepository) {

    fun findAll(): List<Location> = locationRepository.findAll()

    fun findById(id: Long): Location? = locationRepository.findById(id).orElse(null)

    fun save(location: Location): Location = locationRepository.save(location)

    @Transactional
    fun update(id: Long, location: Location): Location? {
        val existingLocation = locationRepository.findById(id).orElse(null) ?: return null
        val updatedLocation = existingLocation.copy(
            address = location.address,
            city = location.city,
            country = location.country
        )
        return locationRepository.save(updatedLocation)
    }

    fun deleteById(id: Long) = locationRepository.deleteById(id)
}