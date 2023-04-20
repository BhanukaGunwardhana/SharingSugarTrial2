package com.sharingsugar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long statusId;

    private String statusName;

    @OneToMany(
            mappedBy = "statusEntity",
            cascade = {CascadeType.REMOVE,CascadeType.REFRESH}
    )
    private List<LocationEntity> locationEntityList;

    @OneToMany(
            mappedBy = "statusEntity",
            cascade = {CascadeType.REMOVE,CascadeType.REFRESH}
    )
    private List<SubCategoryEntity> subCategoryEntityList;


}
