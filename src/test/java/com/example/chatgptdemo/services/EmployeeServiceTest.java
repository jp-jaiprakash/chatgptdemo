//package com.example.chatgptdemo.services;
//
//
//import com.example.chatgptdemo.dto.Employee;
//import com.example.chatgptdemo.services.EmployeeService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(MockitoJUnitRunner.class)
//public class EmployeeServiceTest {
//
//    @Mock
//    private EmployeeRepository employeeRepository;
//
//    @InjectMocks
//    private EmployeeService employeeService;
//
//    @Test
//    public void testGetAllEmployees() {
//        List<Employee> employees = Arrays.asList(
//                new Employee(1L, "John", "Doe", "john.doe@example.com"),
//                new Employee(2L, "Jane", "Doe", "jane.doe@example.com")
//        );
//        given(employeeRepository.findAll()).willReturn(employees);
//
//        List<Employee> result = employeeService.getAllEmployees();
//
//        assertThat(result).isEqualTo(employees);
//    }
//
//    @Test
//    public void testGetEmployeeById() {
//        Employee employee = new Employee(1L, "John", "Doe", "john.doe@example.com");
//        given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));
//
//        Employee result = employeeService.getEmployeeById(1L);
//
//        assertThat(result).isEqualTo(employee);
//    }
//
//    @Test
//    public void testCreateEmployee() {
//        Employee employee = new Employee(null, "John", "Doe", "john.doe@example.com");
//        given(employeeRepository.save(employee)).willReturn(employee);
//
//        Employee result = employeeService.createEmployee(employee);
//
//        assertThat(result).isEqualTo(employee);
//    }
//
//    @Test
//    public void testUpdateEmployee() {
//        Employee employee = new Employee(1L, "John", "Doe", "john.doe@example.com");
//        given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));
//        given(employeeRepository.save(employee)).willReturn(employee);
//
//        Employee updatedEmployee = new Employee(1L, "Jane", "Doe", "jane.doe@example.com");
//        Employee result = employeeService.updateEmployee(1L, updatedEmployee);
//
//        assertThat(result).isEqualTo(updatedEmployee);
//    }
//
//    @Test
//    public void testDeleteEmployee() {
//        given(employeeRepository.existsById(1L)).willReturn(true);
//        given(employeeRepository.deleteById(1L)).willReturn(null);
//
//        boolean result = employeeService.deleteEmployee(1L);
//
//        assertThat(result).isTrue();
//    }
//}
