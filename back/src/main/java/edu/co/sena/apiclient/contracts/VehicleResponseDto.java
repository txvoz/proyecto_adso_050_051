package edu.co.sena.apiclient.contracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleResponseDto {

    private Long id;
    private String plate;

    private String color;

    private String brand;

    public String description;

    private String type;
}
