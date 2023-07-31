package com.example.RentCarProject.dto.User;

import lombok.Data;

@Data
public class ResetPasswordDTO {
    private String email;
    private String newPassword;
    private String resetToken; // Şifre sıfırlama için kullanılacak gizli kod (token)
}
