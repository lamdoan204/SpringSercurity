package com.Project.CongNghePhanMem.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.RestController;

import com.Project.CongNghePhanMem.Model.Customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@EnableMethodSecurity
public class CustomerController {
    final private List<Customer> customers = List.of(
        Customer.builder().id(1).name("Đoàn Quang Lâm").
        email("DoanQuangLam@gmail.com").build()

    );

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello is guest");
    }

    @GetMapping("customer/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Customer>> getCustomerList(){
        List<Customer> list = this.customers;
        return ResponseEntity.ok(list);
    }

    @GetMapping("customer/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Customer> getCustomerList(@PathVariable("id") int id){
        List<Customer> customers = this.customers.stream().filter(customer -> customer.getId() == id).toList();
        return ResponseEntity.ok(customers.get(0));
    }

    public List<Customer> getCustomers() {
        return customers;
    }
    
}
