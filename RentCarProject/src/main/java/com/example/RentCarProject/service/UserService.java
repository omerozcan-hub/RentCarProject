package com.example.RentCarProject.service;

import com.example.RentCarProject.dto.UserDto;
import com.example.RentCarProject.entity.User;
import com.example.RentCarProject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Kullanıcı kaydı
    public User registerUser(UserDto userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setAddress(userDTO.getAddress());
        user.setRole(userDTO.getRole());

        return userRepository.save(user);
    }

    // Kullanıcı girişi
    public boolean loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return false; // Kullanıcı bulunamadı.
        }

        return passwordEncoder.matches(password, user.getPassword());
    }

    // Şifre sıfırlama
    public boolean resetPassword(String email, String newPassword) {
        //Belki eski şifre onayı eklenir ya da email çıkartılabilir
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return false; // Kullanıcı bulunamadı.
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        return true;
    }

    // Kullanıcıları yönetme (örneğin, kullanıcıları listeleme, kullanıcıları güncelleme, kullanıcıları silme vb.)
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users==null){
            System.out.println("kullanıcı verisi yok null");
            return null;
        }else{
            return users.stream()
                    .map(user -> modelMapper.map(user, UserDto.class))
                    .collect(Collectors.toList());
        }
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(UserDto userDTO) {
        User user = userRepository.findById(userDTO.getId()).orElse(null);
        if (user != null) {
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setPhoneNumber(userDTO.getPhoneNumber());
            user.setAddress(userDTO.getAddress());
            userRepository.save(user);
        }
        return user;
    }

    public boolean deleteUser(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }
}
