package com.reviews.api.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
class Customer(
    val firstName: String,
    val lastName: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1) {

    private constructor() : this("", "")
}