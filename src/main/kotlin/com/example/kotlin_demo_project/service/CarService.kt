package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Car
import com.example.kotlin_demo_project.repositories.CarRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CarService(private val carRepository: CarRepository) {

    fun findAll(): List<Car> = carRepository.findAll()

    fun findById(id: Long): Car? = carRepository.findById(id).orElse(null)

    fun findByLicensePlate(licensePlate: String): Car? = carRepository.findByLicensePlate(licensePlate)

    fun save(car: Car): Car = carRepository.save(car)

    @Transactional
    fun update(id: Long, car: Car): Car? {
        val existingCar = carRepository.findById(id).orElse(null) ?: return null

        val updatedCar = existingCar.copy(
            licensePlate = car.licensePlate,
            brand = car.brand,
            model = car.model,
            manufactureYear = car.manufactureYear,
            mileage = car.mileage,
            status = car.status,
            rentalAgency = car.rentalAgency,
            category = car.category,
            rentals = existingCar.rentals  // Maintain the existing rentals
        )

        // Save the updated car back to the database
        return carRepository.save(updatedCar)
    }


    fun deleteById(id: Long) = carRepository.deleteById(id)
}