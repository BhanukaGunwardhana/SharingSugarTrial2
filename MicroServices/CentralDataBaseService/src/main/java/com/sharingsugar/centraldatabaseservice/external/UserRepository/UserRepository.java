package com.sharingsugar.centraldatabaseservice.external.UserRepository;

import com.sharingsugar.centraldatabaseservice.model.Entity.UserEntity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
