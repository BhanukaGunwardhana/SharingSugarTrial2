package com.sharingsugar.centraldatabaseservice.model.Entity.MasterDataEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "status")
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
