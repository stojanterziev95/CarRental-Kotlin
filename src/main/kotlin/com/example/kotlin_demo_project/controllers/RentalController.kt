package com.example.kotlin_demo_project.controllers

import com.example.kotlin_demo_project.models.Rental
import com.example.kotlin_demo_project.service.RentalService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/rentals")
class RentalController(private val rentalService: RentalService) {

    @GetMapping
    fun getAllRentals(): List<Rental> = rentalService.findAll()

    @GetMapping("/{id}")
    fun getRentalById(@PathVariable id: Long): ResponseEntity<Rental> {
        val rental = rentalService.findById(id)
        return rental?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createRental(@RequestBody rental: Rental): Rental = rentalService.save(rental)

    @PutMapping("/{id}")
    fun updateRental(@PathVariable id: Long, @RequestBody rental: Rental): ResponseEntity<Rental> {
        val updatedRental = rentalService.update(id, rental)
        return updatedRental?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteRental(@PathVariable id: Long): ResponseEntity<Void> {
        rentalService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
