package com.example.PaySysytem.api.controller

import com.example.PaySysytem.domain.dto.FeeDTO
import com.example.PaySysytem.domain.entity.FeePolicy
import com.example.PaySysytem.domain.service.FeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class FeeController {

    @Autowired
    lateinit var feeService: FeeService

    @PostMapping("/fee")
    fun addFee(@RequestBody dto: FeeDTO): FeePolicy {
        return this.feeService.addFee(dto)
    }

    @GetMapping("/fee")
    fun getFeeList(): List<FeePolicy> {
        return this.feeService.getFeeList()
    }
}