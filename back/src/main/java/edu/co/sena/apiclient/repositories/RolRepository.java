package edu.co.sena.apiclient.repositories;

import edu.co.sena.apiclient.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends
        JpaRepository<RolEntity, Long>,
        JpaSpecificationExecutor<RolEntity> {
}
