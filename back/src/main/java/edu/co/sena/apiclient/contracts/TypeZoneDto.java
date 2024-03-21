package edu.co.sena.apiclient.contracts;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeZoneDto {
    private String title;
    private List<ZoneDto> zones;
}
