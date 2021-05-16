package com.example.PaySysytem.infrastructure.repository

import com.example.PaySysytem.domain.entity.FeePolicy
import org.springframework.data.jpa.repository.JpaRepository;

interface FeePolicyRepository: JpaRepository<FeePolicy, Long> {
    fun getTopByOrderByIdDesc(): FeePolicy
}