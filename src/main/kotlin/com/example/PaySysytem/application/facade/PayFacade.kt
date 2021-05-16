package com.example.PaySysytem.application.facade

import com.example.PaySysytem.application.dto.PayDTO
import com.example.PaySysytem.domain.service.FeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class PayFacade(private val feeService: FeeService) {

    fun pay(dto: PayDTO): Int? {
        val (price: Int) = dto
        val (_, fixedFee: Int, percentage: Int) = this.feeService.getLatestFeePolicy()

        return deduct(price, fixedFee, percentage)
    }

    // 데이터 변환, 데이터 가져오기 정도만
    // 비즈니스 로직임 (facade X)
    private fun deduct(price: Int, fixedFee: Int, percentage: Int): Int {
        if (price < 10000)
            return this.feeService.deductFixedFeeToPrice(price, fixedFee)
        return this.feeService.deductPercentageFeeToPrice(price, percentage)
    }
}