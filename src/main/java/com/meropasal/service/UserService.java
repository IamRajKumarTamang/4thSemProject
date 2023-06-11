package com.meropasal.service;


import com.meropasal.model.User;
import com.meropasal.model.dto.UserGetDto;
import com.meropasal.model.dto.UserPostDto;

import java.util.List;

public interface UserService {
    UserGetDto  saveUser(UserPostDto userPostDto);
    UserGetDto updateUser(UserPostDto userPostDto, int id);
    String deleteUser(int UserId);
    UserGetDto getSingleUser(int userId);

    List<UserGetDto> getAllUsers();

    String doLogin(UserPostDto userPostDto);
}
