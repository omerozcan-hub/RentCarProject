package com.example.RentCarProject.controller;

import com.example.RentCarProject.dto.User.LoginDTO;
import com.example.RentCarProject.dto.User.ResetPasswordDTO;
import com.example.RentCarProject.dto.UserDto;
import com.example.RentCarProject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Kullanıcı kaydı için POST isteği
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
        return ResponseEntity.ok("Kullanıcı başarıyla kaydedildi.");
    }

    // Kullanıcı girişi için POST isteği
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO) {
        if (userService.loginUser(loginDTO.getEmail(), loginDTO.getPassword())){
            String token ="Giriş Yapıldı" ;
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.ok("Giriş Yapılamadı");

    }

    // Kullanıcı şifresini sıfırlamak için PUT isteği
    @PutMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordDTO resetPasswordRequest) {
        userService.resetPassword(resetPasswordRequest.getEmail(), resetPasswordRequest.getNewPassword());
        return ResponseEntity.ok("Şifre başarıyla sıfırlandı.");
    }

    // Tüm kullanıcıları listelemek için GET isteği
    @GetMapping(path = "get")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
