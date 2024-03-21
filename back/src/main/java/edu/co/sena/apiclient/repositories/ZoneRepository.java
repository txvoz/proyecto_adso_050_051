package edu.co.sena.apiclient.repositories;

import edu.co.sena.apiclient.entities.ZoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends
        JpaRepository<ZoneEntity, Long>,
        JpaSpecificationExecutor<ZoneEntity> {

}
