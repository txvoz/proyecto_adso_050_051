package edu.co.sena.apiclient.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicle")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "plate")
    private String plate;

    @Column(name = "color")
    private String color;

    @Column(name = "description")
    private String description;

    @Column(name = "brand")
    private String brand;

    @ManyToOne
    @JoinColumn(name = "reference_type_id", nullable = false, updatable = false)
    private ReferenceTypeEntity referenceType;
}
