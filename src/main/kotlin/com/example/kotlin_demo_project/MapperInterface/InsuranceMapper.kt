package com.example.kotlin_demo_project.MapperInterface

import com.example.kotlin_demo_project.DTO.InsuranceCreateDTO
import com.example.kotlin_demo_project.DTO.InsuranceDTO
import com.example.kotlin_demo_project.models.Insurance
import com.example.kotlin_demo_project.models.Rental
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
interface InsuranceMapper {

    @Mapping(source = "rental.id", target = "rentalId") // Maps from Insurance to InsuranceDTO
    fun toInsuranceDTO(insurance: Insurance): InsuranceDTO

    @Mapping(source = "insuranceDTO.rentalId", target = "rental.id") // Correct mapping reference
    fun toInsurance(insuranceDTO: InsuranceCreateDTO, rental: Rental): Insurance
}