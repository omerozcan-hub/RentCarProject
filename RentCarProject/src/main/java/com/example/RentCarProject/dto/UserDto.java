package com.example.RentCarProject.dto;

import com.example.RentCarProject.entity.Role;
import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private Role role;

    // Getter ve setter metotları

    // Boş constructor
    public UserDto() {
    }

    // Kullanıcı kaydı için kullanılacak constructor
    public UserDto(String firstName, String lastName, String email, String password, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }


}

