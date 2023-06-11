package com.meropasal.service.serviceImpl;

import com.meropasal.mapper.UserMapper;
import com.meropasal.model.User;
import com.meropasal.model.dto.UserGetDto;
import com.meropasal.model.dto.UserPostDto;
import com.meropasal.repository.UserRepository;
import com.meropasal.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserGetDto saveUser(UserPostDto userPostDto) {
        userPostDto.setPassword(DigestUtils.md5DigestAsHex(userPostDto.getPassword().getBytes()));
        User user = userMapper.UserPostDtoToUser(userPostDto);
        return userMapper.userToUserGetDto(userRepository.save(user));
    }

    @Override
    public UserGetDto updateUser(UserPostDto userPostDto, int id) {
        User user = userRepository.findById(id).get();
        user.setId(id);
        user.setUsername(userPostDto.getUsername());
        user.setEmail(userPostDto.getEmail());
        user.setFirstName(userPostDto.getFirstName());
        user.setLastName(userPostDto.getLastName());
        user.setContactNum(userPostDto.getContactNum());
        return userMapper.userToUserGetDto(userRepository.save(user));
    }

    @Override
    public String deleteUser(int userId) {
        User user = userRepository.findById(userId).get();
        user.setDeleted(true);
        user.setId(userId);
        userRepository.save(user);
        return "User Deleted Successfully";
    }

    @Override
    public UserGetDto getSingleUser(int userId) {
        return userMapper.userToUserGetDto(userRepository.findById(userId).get());
    }

    @Override
    public List<UserGetDto> getAllUsers() {
        return userMapper.userToUserGEtDtoList(userRepository.findAll());
    }

    @Override
    public String  doLogin(UserPostDto userPostDto) {
        userPostDto.setPassword(DigestUtils.md5DigestAsHex(userPostDto.getPassword().getBytes()));
        User user =userRepository.findByUsernameAndPassword(userPostDto.getUsername(),userPostDto.getPassword());
        if(user!=null){
            return user.getUsername();
        }else {
            return null;
        }

    }
}
