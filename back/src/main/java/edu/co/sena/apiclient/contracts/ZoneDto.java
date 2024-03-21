package edu.co.sena.apiclient.contracts;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZoneDto {
    private Long id;
    private String title;
    private String status;
}
