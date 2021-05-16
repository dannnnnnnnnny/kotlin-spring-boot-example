package com.example.paysysytem.api.controller

import com.example.PaySysytem.application.dto.PayDTO
import com.example.PaySysytem.application.facade.PayFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PayController {

    @Autowired
    private lateinit var payFacade: PayFacade

    @PostMapping("/pay")
    fun pay(@RequestBody dto: PayDTO): Int? {
        return this.payFacade.pay(dto)
    }
}