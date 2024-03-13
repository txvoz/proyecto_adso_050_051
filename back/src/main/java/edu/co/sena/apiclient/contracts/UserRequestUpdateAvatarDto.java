package edu.co.sena.apiclient.contracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestUpdateAvatarDto {

    private Long id;
    private String avatar;

}
