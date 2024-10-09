package com.example.kotlin_demo_project.controllers

import com.example.kotlin_demo_project.models.Insurance
import com.example.kotlin_demo_project.service.InsuranceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/insurances")
class InsuranceController(private val insuranceService: InsuranceService) {

    @GetMapping
    fun getAllInsurances(): List<Insurance> = insuranceService.findAll()

    @GetMapping("/{id}")
    fun getInsuranceById(@PathVariable id: Long): ResponseEntity<Insurance> {
        val insurance = insuranceService.findById(id)
        return insurance?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createInsurance(@RequestBody insurance: Insurance): Insurance = insuranceService.save(insurance)

    @PutMapping("/{id}")
    fun updateInsurance(@PathVariable id: Long, @RequestBody insurance: Insurance): ResponseEntity<Insurance> {
        val updatedInsurance = insuranceService.update(id, insurance)
        return updatedInsurance?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteInsurance(@PathVariable id: Long): ResponseEntity<Void> {
        insuranceService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}
