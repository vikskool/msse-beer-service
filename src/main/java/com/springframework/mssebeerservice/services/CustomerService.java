package com.springframework.mssebeerservice.services;



import com.springframework.mssebeerservice.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomer(UUID customerId);

    CustomerDto createCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteCustomer(UUID customerId);
}
