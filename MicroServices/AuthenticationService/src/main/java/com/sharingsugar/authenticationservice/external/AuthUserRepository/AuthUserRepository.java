package com.sharingsugar.authenticationservice.external.AuthUserRepository;

import com.sharingsugar.authenticationservice.model.Entity.AuthUserEntity;
import org.springframework.boot.json.JsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUserEntity,Long> {
}
