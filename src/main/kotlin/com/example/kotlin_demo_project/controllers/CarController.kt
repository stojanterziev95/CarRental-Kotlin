package com.example.kotlin_demo_project.controllers

import com.example.kotlin_demo_project.models.Car
import com.example.kotlin_demo_project.service.CarService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cars")
class CarController(private val carService: CarService) {

    @GetMapping
    fun getAllCars(): List<Car> = carService.findAll()

    @GetMapping("/{id}")
    fun getCarById(@PathVariable id: Long): ResponseEntity<Car> {
        val car = carService.findById(id)
        return car?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createCar(@RequestBody car: Car): Car = carService.save(car)

    @PutMapping("/{id}")
    fun updateCar(@PathVariable id: Long, @RequestBody car: Car): ResponseEntity<Car> {
        val updatedCar = carService.update(id, car)
        return updatedCar?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCar(@PathVariable id: Long): ResponseEntity<Void> {
        carService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}