package com.example.paysysytem.api.controller

import com.example.PaySysytem.application.dto.PayDTO
import com.example.PaySysytem.application.facade.PayFacade
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PayController(private val payFacade: PayFacade) {

    @PostMapping("/payments")
    fun pay(@RequestBody dto: PayDTO): Int? {
        return this.payFacade.pay(dto)
    }
}