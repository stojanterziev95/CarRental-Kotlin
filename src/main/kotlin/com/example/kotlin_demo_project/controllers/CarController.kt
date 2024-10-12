package com.example.kotlin_demo_project.controllers

import com.example.kotlin_demo_project.DTO.CarDTO
import com.example.kotlin_demo_project.DTO.CreateCarDTO
import com.example.kotlin_demo_project.service.CarService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cars")
class CarController(private val carService: CarService) {

    @GetMapping
    fun getAllCars(): List<CarDTO> = carService.findAll()

    @GetMapping("/{id}")
    fun getCarById(@PathVariable id: Long): ResponseEntity<CarDTO> {
        val car = carService.findById(id)
        return car?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createCar(@RequestBody carCreateDTO: CreateCarDTO): CarDTO = carService.save(carCreateDTO)

    @PutMapping("/{id}")
    fun updateCar(@PathVariable id: Long, @RequestBody carCreateDTO: CreateCarDTO): ResponseEntity<CarDTO> {
        val updatedCar = carService.update(id, carCreateDTO)
        return updatedCar?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCar(@PathVariable id: Long): ResponseEntity<Void> {
        carService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
