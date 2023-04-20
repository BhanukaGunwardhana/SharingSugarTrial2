package com.sharingsugar.centraldatabaseservice.external.MasterDataRepository;

import com.sharingsugar.centraldatabaseservice.model.Entity.MasterDataEntity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity,Long> {
}
