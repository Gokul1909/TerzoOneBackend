//package com.terzoOne.terzoOneBackend.service.impl;
//
//package com.example.springMVC.service.implementation;
//
//import com.example.springMVC.dto.RegistrationDto;
//import com.example.springMVC.models.Role;
//import com.example.springMVC.models.UserEntity;
//import com.example.springMVC.repository.RoleRepository;
//import com.example.springMVC.repository.UserRepository;
//import com.example.springMVC.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//
//@Service
//public class UserServiceImpl implements UserService {
//    private UserRepository userRepository;
//    private RoleRepository roleRepository;
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void saveUser(RegistrationDto registrationDto) {
//        UserEntity user = new UserEntity();
//        user.setUsername(registrationDto.getUsername());
//        user.setEmail(registrationDto.getEmail());
//        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
//        Role role = roleRepository.findByName("USER");
//        user.setRoles(Arrays.asList(role));
//        userRepository.save(user);
//    }
//
//    @Override
//    public UserEntity findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    @Override
//    public UserEntity findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//}
