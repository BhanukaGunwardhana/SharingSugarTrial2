package com.sharingsugar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class SugarPostTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sugarPostTypeId;

    private String sugarPostName;
}
