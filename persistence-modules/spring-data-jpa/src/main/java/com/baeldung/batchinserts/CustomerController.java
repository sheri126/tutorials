package com.baeldung.batchinserts;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.batchinserts.model.Customer;
import com.baeldung.batchinserts.repository.CustomerRepository;

/**
 * A simple controller to test the JPA CrudRepository operations
 * controllers
 * 
 * @author ysharma2512
 *
 */
@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository2) {
        this.customerRepository = customerRepository2;
    }

    @PostMapping("/customers")
    public ResponseEntity<List<Customer>> insertCustomers() throws URISyntaxException {
        Customer c1 = new Customer("James", "Gosling");
        Customer c2 = new Customer("Doug", "Lea");
        Customer c3 = new Customer("Martin", "Fowler");
        Customer c4 = new Customer("Brian", "Goetz");
        List<Customer> customers = Arrays.asList(c1, c2, c3, c4);
        customerRepository.saveAll(customers);
        return ResponseEntity.ok(customers);
    }

}
