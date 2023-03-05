//package com.example.chatgptdemo.entities;
//
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//
//@Entity
//@Table(name="employees")
//@Getter
//@Setter
//public class Employee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Size(max = 100)
//    private String firstName;
//
//    @NotBlank
//    @Size(max = 100)
//    private String lastName;
//
//    @Email
//    @NotBlank
//    @Size(max = 100)
//    private String email;
//
//    public Employee() {}
//
//    public Employee(Long id, String firstName, String lastName, String email) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//    }
//
//    // getters and setters omitted for brevity
//
//}
