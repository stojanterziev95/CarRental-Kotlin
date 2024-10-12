package com.example.kotlin_demo_project.MapperInterface

import com.example.kotlin_demo_project.DTO.CarDTO
import com.example.kotlin_demo_project.DTO.CreateCarDTO
import com.example.kotlin_demo_project.models.Car
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper(componentModel = "spring")
interface CarMapper {
    companion object {
        val INSTANCE: CarMapper = Mappers.getMapper(CarMapper::class.java)
    }

    @Mapping(source = "rentalAgency.name", target = "rentalAgencyName")
    @Mapping(source = "category.type", target = "categoryType")
    fun toCarDTO(car: Car): CarDTO

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rentalAgency", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "rentals", ignore = true)
    fun toCar(carCreateDTO: CreateCarDTO): Car
}