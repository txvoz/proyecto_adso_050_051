package edu.co.sena.apiclient.contracts;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private String name;

    private String lastName;

    private String dni;

    private char gender;

}
