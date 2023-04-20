package com.sharingsugar.centraldatabaseservice.external.MasterDataRepository;

import com.sharingsugar.centraldatabaseservice.model.Entity.MasterDataEntity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity,Long> {
}
