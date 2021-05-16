package com.example.PaySysytem.domain.service

import com.example.PaySysytem.domain.dto.FeeDTO
import com.example.PaySysytem.domain.entity.FeePolicy
import com.example.PaySysytem.infrastructure.repository.FeePolicyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

// @Service로 수정
@Component // service가 아닌 것들을 Bean으로 만들고 싶을 때 사용
class FeeService {

    @Autowired
    lateinit var feePolicyRepository: FeePolicyRepository

    fun getFeeList(): List<FeePolicy> {
        return feePolicyRepository.findAll()
    }

    fun addFee(dto: FeeDTO): FeePolicy {
        return feePolicyRepository.save(FeePolicy(fixedFee = dto.fixedFee, percentage = dto.percentage))
    }

    fun getLatestFeePolicy(): FeePolicy {
            return feePolicyRepository.getTopByOrderByIdDesc()
    }

    fun deductFixedFeeToPrice(price: Int, fixedFee: Int): Int {
        return price - fixedFee
    }

    fun deductPercentageFeeToPrice(price: Int, percentage: Int): Int {
        val fee: Double = ((100 - percentage) / 100.0)
        return (price * fee).toInt()
    }
}