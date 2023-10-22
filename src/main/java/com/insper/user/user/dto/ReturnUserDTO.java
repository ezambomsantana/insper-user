package com.insper.user.user.dto;

import com.insper.user.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReturnUserDTO {
    private String email;
    private String password;
    public static ReturnUserDTO convert(User user) {
        ReturnUserDTO userDTO = new ReturnUserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

}
