package kae.demo.currencytrendsmonitor.server.api.trade;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/** */
public interface UserRepository extends JpaRepository<UserEntity, String> {

  Optional<UserEntity> findBySystemId(String systemId);
}
