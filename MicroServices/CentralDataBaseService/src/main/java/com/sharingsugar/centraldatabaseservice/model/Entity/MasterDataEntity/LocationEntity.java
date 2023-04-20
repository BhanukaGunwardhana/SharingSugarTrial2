package com.sharingsugar.centraldatabaseservice.model.Entity.MasterDataEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "location")
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long locationId;

    private String locationName;

    @ManyToOne
    @JoinColumn(
            name = "locationId_statusId",
            referencedColumnName = "statusId"

    )
    private StatusEntity statusEntity;

}
