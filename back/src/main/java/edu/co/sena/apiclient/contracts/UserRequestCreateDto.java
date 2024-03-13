package edu.co.sena.apiclient.contracts;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestCreateDto {

    private Long id;

    private String fullName;

    private Date bornDate;

    private String color;

    private String email;

    private String phone;

    private String avatar;

    private Long rol;
}
