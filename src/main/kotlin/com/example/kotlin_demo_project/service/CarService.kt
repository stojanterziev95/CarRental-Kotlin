package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Car
import com.example.kotlin_demo_project.repositories.CarRepository
import org.springframework.stereotype.Service

@Service
class CarService(private val carRepository: CarRepository) {

    fun findAll(): List<Car> = carRepository.findAll()

    fun findById(id: Long): Car? = carRepository.findById(id).orElse(null)

    fun findByLicensePlate(licensePlate: String): Car? = carRepository.findByLicensePlate(licensePlate)

    fun save(car: Car): Car = carRepository.save(car)

    fun deleteById(id: Long) = carRepository.deleteById(id)
}