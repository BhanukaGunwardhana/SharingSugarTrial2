package com.sharingsugar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long locationId;

    private String locationName;

    @ManyToOne
    @JoinColumn(
            name = "locationId_tatusId",
            referencedColumnName = "statusId"

    )
    private StatusEntity statusEntity;











//    @ManyToOne
//    @JoinColumn(
//            name = "locationId_tatusId",
//            referencedColumnName = "statusId"
//
//    )
//    private StatusEntity statusEntity;

}
