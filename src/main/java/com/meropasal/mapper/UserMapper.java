package com.meropasal.mapper;


import com.meropasal.model.User;
import com.meropasal.model.dto.UserGetDto;
import com.meropasal.model.dto.UserPostDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface UserMapper {
    UserGetDto userToUserGetDto(User user);

    UserPostDto userToUserPostDto(User user);

    User UserGetDtoToUser(UserGetDto userGetDto);

    User UserPostDtoToUser(UserPostDto userPostDto);

    List<UserGetDto> userToUserGEtDtoList(List<User> userList);

}
