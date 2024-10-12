package com.example.kotlin_demo_project.MapperInterface

import com.example.kotlin_demo_project.DTO.CreateEmployeeDTO
import com.example.kotlin_demo_project.DTO.EmployeeDTO
import com.example.kotlin_demo_project.models.Employee
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper(componentModel = "spring")
interface EmployeeMapper {
    companion object {
        val INSTANCE: EmployeeMapper = Mappers.getMapper(EmployeeMapper::class.java)
    }

    @Mapping(source = "rentalAgency.name", target = "rentalAgencyId")
    fun toEmployeeDTO(employee: Employee): EmployeeDTO

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rentalAgency", ignore = true) // We will set the rental agency manually in the service
    fun toEmployee(createEmployeeDTO: CreateEmployeeDTO): Employee
}