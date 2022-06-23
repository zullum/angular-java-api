package com.reviews.api.service

import com.reviews.api.model.Customer
import com.reviews.api.repo.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) {
    fun createCustomer(customer:Customer): Customer = customerRepository.save(customer)

    fun findAll(): MutableIterable<Customer> = customerRepository.findAll()

    fun findByLastName(lastName: String) = customerRepository.findByLastName(lastName)

    fun findById(customerId: Long): Customer = customerRepository.findById(customerId)
        .orElseThrow { Exception("No matching customer was found") }

    fun updateById(customerId: Long, customer:Customer): Customer {
        return if (customerRepository.existsById(customerId)) {
            customerRepository.save(
                Customer(
                    id = customerId,
                    firstName = customer.firstName,
                    lastName = customer.lastName,

                )
            )
        } else throw Exception("No matching customer was found")
    }

    fun deleteById(customerId: Long): String {
        if (customerRepository.existsById(customerId)) {
           customerRepository.deleteById(customerId)
            return "Customer has been deleted"
        } else throw Exception("No matching customer was found")
    }
}