package com.springboot.applicationtesting.controllers;

import com.springboot.applicationtesting.TestContainerConfiguration;
import com.springboot.applicationtesting.dto.EmployeeDto;
import com.springboot.applicationtesting.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import java.time.Duration;

// @AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestContainerConfiguration.class)
public class AbstractIntegrationTest {

    @LocalServerPort
    private int localPort;

    WebTestClient webTestClient;

    @BeforeEach
    void setUpWebClient() {
        this.webTestClient = WebTestClient
                .bindToServer()
                .baseUrl("http://localhost:" + localPort)
                .responseTimeout(Duration.ofSeconds(100))
                .build();
    }

    Employee testEmployee = Employee.builder()
            .email("mansi@gmail.com")
            .name("Mansi")
            .salary(200L)
            .build();

    EmployeeDto testEmployeeDto = EmployeeDto.builder()
//            .id(1L)
            .email("mansi@gmail.com")
            .name("Mansi")
            .salary(200L)
            .build();
}