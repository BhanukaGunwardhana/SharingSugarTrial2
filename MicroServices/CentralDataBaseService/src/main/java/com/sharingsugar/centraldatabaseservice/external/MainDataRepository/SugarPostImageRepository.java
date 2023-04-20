package com.sharingsugar.centraldatabaseservice.external.MainDataRepository;

import com.sharingsugar.centraldatabaseservice.model.Entity.SharingSugarMainEntity.SugarPostImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugarPostImageRepository extends JpaRepository<SugarPostImageEntity,Long> {
}
