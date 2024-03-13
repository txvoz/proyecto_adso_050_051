package edu.co.sena.apiclient.contracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDetailDto {

    private Long id;

    private String fullName;

    private Date bornDate;

    private String color;

    private String email;

    private String phone;

    private String avatarFilePath;

    private RolResponseDto rol;
}
