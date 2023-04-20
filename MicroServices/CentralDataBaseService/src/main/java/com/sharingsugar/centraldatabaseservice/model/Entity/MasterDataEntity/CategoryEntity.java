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
@Entity(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;

    private String categoryName;

    @OneToMany(
            mappedBy = "categoryEntity",
            cascade = {CascadeType.REMOVE,CascadeType.REFRESH}
    )
    private List<SubCategoryEntity> subCategoryEntity;
}
