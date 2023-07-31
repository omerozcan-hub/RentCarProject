package com.example.RentCarProject.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDTO {
    private String email;
    private String password;

    // Getters and setters (Constructor oluşturmak da isterseniz)
}

