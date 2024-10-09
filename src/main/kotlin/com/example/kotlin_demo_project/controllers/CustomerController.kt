package com.example.kotlin_demo_project.controllers

import com.example.kotlin_demo_project.models.Customer
import com.example.kotlin_demo_project.service.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping
    fun getAllCustomers(): List<Customer> = customerService.findAll()

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: Long): ResponseEntity<Customer> {
        val customer = customerService.findById(id)
        return customer?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createCustomer(@RequestBody customer: Customer): Customer = customerService.save(customer)

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable id: Long, @RequestBody customer: Customer): ResponseEntity<Customer> {
        val updatedCustomer = customerService.update(id, customer)
        return updatedCustomer?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long): ResponseEntity<Void> {
        customerService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}