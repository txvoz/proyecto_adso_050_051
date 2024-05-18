package edu.co.sena.apiclient.repositories;

import edu.co.sena.apiclient.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VehicleRepository extends
        JpaRepository<VehicleEntity, Long>,
        JpaSpecificationExecutor<VehicleEntity> {

    VehicleEntity getByPlate(String plate);

}
