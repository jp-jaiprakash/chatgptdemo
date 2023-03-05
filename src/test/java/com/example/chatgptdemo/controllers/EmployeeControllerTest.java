package com.example.chatgptdemo.controllers;

import com.example.chatgptdemo.dto.Employee;
import com.example.chatgptdemo.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testGetAllEmployees() throws Exception {
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "John", "Doe", "john.doe@example.com"),
                new Employee(2L, "Jane", "Doe", "jane.doe@example.com")
        );
        given(employeeService.getAllEmployees()).willReturn(employees);

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(employees)));
    }

//    @Test
//    public void testGetEmployeeById() throws Exception {
//        Employee employee = new Employee(1L, "John", "Doe", "john.doe@example.com");
//        given(employeeService.getEmployeeById(1L)).willReturn(employee);
//
//        mockMvc.perform(get("/employees/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(employee)));
//    }

    @Test
    public void testCreateEmployee() throws Exception {
        Employee employee = new Employee(null, "John", "Doe", "john.doe@example.com");
        given(employeeService.createEmployee(any())).willReturn(employee);

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(employee)));
    }

//    @Test
//    public void testUpdateEmployee() throws Exception {
//        Employee employee = new Employee(1L, "John", "Doe", "john.doe@example.com");
//        given(employeeService.updateEmployee(eq(1L), any())).willReturn(employee);
//
//        mockMvc.perform(put("/employees/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(employee)))
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(employee)));
//    }
//
//    @Test
//    public void testDeleteEmployee() throws Exception {
//        given(employeeService.deleteEmployee(1L)).willReturn(true);
//
//        mockMvc.perform(delete("/employees/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("true"));
//    }

}
