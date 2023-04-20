package com.sharingsugar.centraldatabaseservice.model.Entity.SharingSugarMainEntity;

import com.sharingsugar.centraldatabaseservice.model.Entity.MasterDataEntity.*;
import com.sharingsugar.centraldatabaseservice.model.Entity.UserEntity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "sugarpostentity")
public class SugarPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long sugarPostId;

    private String title;

    private String description;

    private String value;

    private LocalDate availableStartDate;

    private LocalDate availableEndDate;

    private LocalDateTime createdAt;

    private Boolean isGlobal;

    @ManyToOne
    @JoinColumn(
            name = "sugarPostId_categoryId",
            referencedColumnName = "categoryId"
    )
    private CategoryEntity Category;

    @ManyToOne
    @JoinColumn(
            name = "sugarPostId_subcategoryId",
            referencedColumnName = "subCategoryId"
    )
    private SubCategoryEntity SubCategory;

    @ManyToOne
    @JoinColumn(
            name = "sugarPostId_stausId",
            referencedColumnName = "statusId"
    )
    private StatusEntity status;

    @ManyToOne
    @JoinColumn(
            name = "sugarPostId_locationId",
            referencedColumnName = "locationId"
    )
    private LocationEntity location;

    @ManyToOne
    @JoinColumn(
            name = "sugarPostId_userId",
            referencedColumnName = "userId"
    )
    private UserEntity user;


    @ManyToOne
    @JoinColumn(
            name = "sugarPostId_sugarPostTypeId",
            referencedColumnName = "sugarPostTypeId"
    )
    private SugarPostTypeEntity sugarPostType;

}
