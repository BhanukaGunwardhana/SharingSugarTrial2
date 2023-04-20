package com.sharingsugar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CategoryEntity{
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
