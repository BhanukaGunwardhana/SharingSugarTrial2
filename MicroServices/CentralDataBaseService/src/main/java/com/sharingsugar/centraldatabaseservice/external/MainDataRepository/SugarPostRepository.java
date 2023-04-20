package com.sharingsugar.centraldatabaseservice.external.MainDataRepository;

import com.sharingsugar.centraldatabaseservice.model.Entity.SharingSugarMainEntity.SugarPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugarPostRepository extends JpaRepository<SugarPostEntity,Long> {
}
