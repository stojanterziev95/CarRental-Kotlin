package com.example.kotlin_demo_project.controllers

import com.example.kotlin_demo_project.models.Location
import com.example.kotlin_demo_project.service.LocationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/locations")
class LocationController(private val locationService: LocationService) {

    @GetMapping
    fun getAllLocations(): List<Location> = locationService.findAll()

    @GetMapping("/{id}")
    fun getLocationById(@PathVariable id: Long): ResponseEntity<Location> {
        val location = locationService.findById(id)
        return location?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createLocation(@RequestBody location: Location): Location = locationService.save(location)

    @PutMapping("/{id}")
    fun updateLocation(@PathVariable id: Long, @RequestBody location: Location): ResponseEntity<Location> {
        val updatedLocation = locationService.update(id, location)
        return updatedLocation?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteLocation(@PathVariable id: Long): ResponseEntity<Void> {
        locationService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}