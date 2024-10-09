package com.example.kotlin_demo_project.service

import com.example.kotlin_demo_project.models.Reservation
import com.example.kotlin_demo_project.repositories.ReservationRepository
import org.springframework.stereotype.Service

@Service
class ReservationService(private val reservationRepository: ReservationRepository) {

    fun findAll(): List<Reservation> = reservationRepository.findAll()

    fun findById(id: Long): Reservation? = reservationRepository.findById(id).orElse(null)

    fun save(reservation: Reservation): Reservation = reservationRepository.save(reservation)

    fun deleteById(id: Long) = reservationRepository.deleteById(id)
}