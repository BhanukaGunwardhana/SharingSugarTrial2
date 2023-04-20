package com.sharingsugar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
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
    private LocalDate createdAt;

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
}
