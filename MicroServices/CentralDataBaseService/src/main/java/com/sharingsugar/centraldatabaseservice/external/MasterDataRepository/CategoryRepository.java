package com.sharingsugar.centraldatabaseservice.external.MasterDataRepository;

import com.sharingsugar.centraldatabaseservice.model.Entity.MasterDataEntity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}
