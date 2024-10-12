package com.example.kotlin_demo_project.MapperInterface

import com.example.kotlin_demo_project.DTO.CategoryCreateDTO
import com.example.kotlin_demo_project.DTO.CategoryDTO
import com.example.kotlin_demo_project.models.Category
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CategoryMapper {
    fun toDTO(category: Category): CategoryDTO
    fun toModel(categoryCreateDTO: CategoryCreateDTO): Category
}