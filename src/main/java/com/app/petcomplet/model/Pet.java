package com.app.petcomplet.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table(name="pets")
public class Pet {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="pet_uuid")
    private String id;

    @Column
    private String name;

    @Column
    private String breed;


}
