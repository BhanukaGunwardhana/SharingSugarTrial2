package com.sharingsugar.centraldatabaseservice.model.Entity.SharingSugarMainEntity;

import com.sharingsugar.centraldatabaseservice.model.Entity.MasterDataEntity.StatusEntity;
import com.sharingsugar.centraldatabaseservice.model.Entity.UserEntity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "sugarpostrequest")
public class SugarPostRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sugarPostRequestId;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(
            name="sugarPostRequestId_statusId",
            referencedColumnName = "statusId"
    )

    private StatusEntity statusId;

    @ManyToOne
    @JoinColumn(
            name="sugarPostRequestId_userId",
            referencedColumnName = "userId"
    )
    private UserEntity userId;


    @ManyToOne
    @JoinColumn(
            name="sugarPostRequestId_wantSugarId",
            referencedColumnName = "sugarPostId"
    )
    private SugarPostEntity wantSugarId;


    @ManyToOne
    @JoinColumn(
            name="sugarPostRequestId_shareSugarId",
            referencedColumnName = "sugarPOstId"
    )
    private SugarPostEntity shareSugarId;
}
