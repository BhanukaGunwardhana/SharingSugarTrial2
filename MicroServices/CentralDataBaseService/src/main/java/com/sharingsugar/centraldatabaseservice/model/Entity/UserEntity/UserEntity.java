package com.sharingsugar.centraldatabaseservice.model.Entity.UserEntity;

import com.sharingsugar.centraldatabaseservice.model.Entity.MasterDataEntity.LocationEntity;
import com.sharingsugar.centraldatabaseservice.model.Entity.MasterDataEntity.StatusEntity;
import com.sharingsugar.centraldatabaseservice.model.Entity.SharingSugarMainEntity.SugarPostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String userFullName;
    private String userEmail;
    private String userPhoneNumber;
    private String userOrgName;
    private String userPassword;
    private String userProfileImgUrl;
    private LocalDateTime createdAt;

    @ManyToOne(
            //fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "userId_locationId",
            referencedColumnName = "locationId"

    )
    private LocationEntity location;

    @ManyToOne(
            //fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "userId_statusId",
            referencedColumnName = "statusId"

    )
    private StatusEntity status;

    @OneToMany(
            mappedBy = "user",
            cascade = {CascadeType.REFRESH,CascadeType.REMOVE}
    )
    private List<SugarPostEntity> sugarPostList;
}
