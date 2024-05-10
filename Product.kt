package com.example.outputcsv

import jakarta.persistence.*

@Entity
@Table(name = "taxproduct", schema = "data")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val category: String,
    val name: String,
    val price: Int,
    val origin: String
)