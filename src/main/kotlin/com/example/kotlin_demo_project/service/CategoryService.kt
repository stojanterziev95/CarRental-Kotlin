package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Category
import com.example.kotlin_demo_project.repositories.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepository: CategoryRepository) {

    fun findAll(): List<Category> = categoryRepository.findAll()

    fun findById(id: Long): Category? = categoryRepository.findById(id).orElse(null)

    fun save(category: Category): Category = categoryRepository.save(category)

    fun deleteById(id: Long) = categoryRepository.deleteById(id)
}