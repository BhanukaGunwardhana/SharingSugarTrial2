package com.sharingsugar.centraldatabaseservice.model.Entity.MasterDataEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="sugarposttype")
public class SugarPostTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sugarPostTypeId;

    private String sugarPostName;
}
