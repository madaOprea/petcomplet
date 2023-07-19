package com.app.petcomplet.model;

import com.app.petcomplet.constraints.PriceLimit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table(name="consultations")
public class Consultation {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name="pet_uuid")
    private String id;

    @Column
    @PriceLimit
    private Double priceLimit;
}
