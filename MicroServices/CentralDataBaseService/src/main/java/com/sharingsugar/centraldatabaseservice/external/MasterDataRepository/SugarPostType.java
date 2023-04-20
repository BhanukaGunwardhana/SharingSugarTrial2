package com.sharingsugar.centraldatabaseservice.external.MasterDataRepository;

import com.sharingsugar.centraldatabaseservice.model.Entity.MasterDataEntity.SugarPostTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugarPostType extends JpaRepository<SugarPostTypeEntity,Long> {
}
