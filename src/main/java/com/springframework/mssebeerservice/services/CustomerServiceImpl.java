package com.springframework.mssebeerservice.services;


import com.springframework.mssebeerservice.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public CustomerDto getCustomer(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .customerName("Vikram Sinha")
                .build();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .customerName("Vikskool")
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        return;
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.info("Deleting customer with id "+ customerId);
    }
}
