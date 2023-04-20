package com.sharingsugar.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
