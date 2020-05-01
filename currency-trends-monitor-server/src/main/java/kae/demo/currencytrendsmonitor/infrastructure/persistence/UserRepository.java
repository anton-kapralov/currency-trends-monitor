package kae.demo.currencytrendsmonitor.infrastructure.persistence;

import kae.demo.currencytrendsmonitor.domain.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/** */
public interface UserRepository extends JpaRepository<UserEntity, String> {

  Optional<UserEntity> findBySystemId(String systemId);
}
