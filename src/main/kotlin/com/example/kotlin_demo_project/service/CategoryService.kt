package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.DTO.CategoryCreateDTO
import com.example.kotlin_demo_project.DTO.CategoryDTO
import com.example.kotlin_demo_project.MapperInterface.CategoryMapper
import com.example.kotlin_demo_project.models.Category
import com.example.kotlin_demo_project.repositories.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository,
    private val categoryMapper: CategoryMapper
) {

    fun findAll(): List<CategoryDTO> =
        categoryRepository.findAll().map { categoryMapper.toDTO(it) }

    fun findById(id: Long): CategoryDTO? =
        categoryRepository.findById(id).map { categoryMapper.toDTO(it) }.orElse(null)

    fun save(categoryCreateDTO: CategoryCreateDTO): CategoryDTO {
        val category = categoryMapper.toModel(categoryCreateDTO)
        return categoryMapper.toDTO(categoryRepository.save(category))
    }

    fun deleteById(id: Long) = categoryRepository.deleteById(id)
}