package kae.demo.currencytrendsmonitor.infrastructure.persistence;

import kae.demo.currencytrendsmonitor.domain.model.trade.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/** */
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {

  Optional<CurrencyEntity> findByIsoCode(String isoCode);
}
