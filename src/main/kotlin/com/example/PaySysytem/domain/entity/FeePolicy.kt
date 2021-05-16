package com.example.PaySysytem.domain.entity

import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Entity

@Entity
data class FeePolicy (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val fixedFee: Int,
    val percentage: Int,
)