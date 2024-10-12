package com.example.kotlin_demo_project.MapperInterface

import com.example.kotlin_demo_project.DTO.CustomerCreateDTO
import com.example.kotlin_demo_project.DTO.CustomerDTO
import com.example.kotlin_demo_project.models.Customer
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CustomerMapper {
    fun toDTO(customer: Customer): CustomerDTO
    fun toModel(customerCreateDTO: CustomerCreateDTO): Customer
}