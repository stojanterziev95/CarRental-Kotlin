package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Invoice
import com.example.kotlin_demo_project.repositories.InvoiceRepository
import org.springframework.stereotype.Service

@Service
class InvoiceService(private val invoiceRepository: InvoiceRepository) {

    fun findAll(): List<Invoice> = invoiceRepository.findAll()

    fun findById(id: Long): Invoice? = invoiceRepository.findById(id).orElse(null)

    fun save(invoice: Invoice): Invoice = invoiceRepository.save(invoice)

    fun deleteById(id: Long) = invoiceRepository.deleteById(id)
}