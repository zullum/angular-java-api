package com.reviews.api.controller

import com.reviews.api.model.Customer
import com.reviews.api.service.CustomerService
import org.springframework.web.bind.annotation.*

@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
@RestController
class CustomerController(private val customerService: CustomerService) {


    @PostMapping("/save")
    fun createCustomer(@RequestBody payload: Customer): Customer = customerService.createCustomer(payload)

    @GetMapping("/findall")
    fun findAll() = customerService.findAll()

    @GetMapping("/findbyid/{id}")
    fun findById(@PathVariable id: Long)
            = customerService.findById(id)

    @GetMapping("findbylastname/{lastName}")
    fun findByLastName(@PathVariable lastName: String)
            = customerService.findByLastName(lastName)

    @PutMapping("updatebyid/{id}")
    fun updateById(@PathVariable id: Long, @RequestBody payload: Customer)
            = customerService.updateById(id, payload)

    @DeleteMapping("deletebyid/{id}")
    fun deleteById(@PathVariable id: Long)
            = customerService.deleteById(id)

}