package com.sharingsugar.centraldatabaseservice.external.MasterDataRepository;

import com.sharingsugar.centraldatabaseservice.model.Entity.MasterDataEntity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity,Long> {
}
