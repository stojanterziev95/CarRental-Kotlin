package com.example.kotlin_demo_project.controllers

import com.example.kotlin_demo_project.DTO.CategoryCreateDTO
import com.example.kotlin_demo_project.DTO.CategoryDTO
import com.example.kotlin_demo_project.service.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categories")
class CategoryController(private val categoryService: CategoryService) {

    @GetMapping
    fun getAllCategories(): List<CategoryDTO> = categoryService.findAll()

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): ResponseEntity<CategoryDTO> {
        val category = categoryService.findById(id)
        return category?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createCategory(@RequestBody categoryCreateDTO: CategoryCreateDTO): CategoryDTO =
        categoryService.save(categoryCreateDTO)

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Long): ResponseEntity<Void> {
        categoryService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}