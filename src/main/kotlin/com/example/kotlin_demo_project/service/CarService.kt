package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.DTO.CarDTO
import com.example.kotlin_demo_project.DTO.CreateCarDTO
import com.example.kotlin_demo_project.MapperInterface.CarMapper
import com.example.kotlin_demo_project.models.Car
import com.example.kotlin_demo_project.repositories.CarRepository
import com.example.kotlin_demo_project.repositories.CategoryRepository
import com.example.kotlin_demo_project.repositories.RentalAgencyRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CarService(
    private val carRepository: CarRepository,
    private val rentalAgencyRepository: RentalAgencyRepository,
    private val categoryRepository: CategoryRepository
) {
    private val carMapper = CarMapper.INSTANCE

    fun findAll(): List<CarDTO> = carRepository.findAll().map(carMapper::toCarDTO)

    fun findById(id: Long): CarDTO? = carRepository.findById(id)
        .map(carMapper::toCarDTO)
        .orElse(null)

    fun save(carCreateDTO: CreateCarDTO): CarDTO {
        val car = carMapper.toCar(carCreateDTO)
        car.rentalAgency = rentalAgencyRepository.findById(carCreateDTO.rentalAgencyId)
            .orElseThrow { IllegalArgumentException("Rental agency not found") }
        car.category = categoryRepository.findById(carCreateDTO.categoryId)
            .orElseThrow { IllegalArgumentException("Category not found") }
        return carMapper.toCarDTO(carRepository.save(car))
    }

    fun update(id: Long, carCreateDTO: CreateCarDTO): CarDTO? {
        val existingCar = carRepository.findById(id).orElse(null) ?: return null
        val updatedCar = carMapper.toCar(carCreateDTO).copy(id = existingCar.id)
        updatedCar.rentalAgency = rentalAgencyRepository.findById(carCreateDTO.rentalAgencyId)
            .orElseThrow { IllegalArgumentException("Rental agency not found") }
        updatedCar.category = categoryRepository.findById(carCreateDTO.categoryId)
            .orElseThrow { IllegalArgumentException("Category not found") }
        return carMapper.toCarDTO(carRepository.save(updatedCar))
    }

    fun deleteById(id: Long) = carRepository.deleteById(id)
}
