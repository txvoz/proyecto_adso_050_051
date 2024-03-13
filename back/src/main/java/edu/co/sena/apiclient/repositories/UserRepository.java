package edu.co.sena.apiclient.repositories;

import edu.co.sena.apiclient.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends
        JpaRepository<UserEntity, Long>,
        JpaSpecificationExecutor<UserEntity> {


}
