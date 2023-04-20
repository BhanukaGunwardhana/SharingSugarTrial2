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
public class SubCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long subCategoryId;
    private String subCategoryName;

    @ManyToOne
    @JoinColumn(
            name = "subCategoryId_statusId",
            referencedColumnName = "statusId"
    )
    private StatusEntity statusEntity;

    @ManyToOne
    @JoinColumn(
            name = "subCategoryId_categoryId",
            referencedColumnName = "categoryId"
    )
    private CategoryEntity categoryEntity;
}
