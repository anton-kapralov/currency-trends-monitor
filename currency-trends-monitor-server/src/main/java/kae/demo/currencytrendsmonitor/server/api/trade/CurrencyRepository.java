package kae.demo.currencytrendsmonitor.server.api.trade;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/** */
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {

  Optional<CurrencyEntity> findByIsoCode(String isoCode);
}
