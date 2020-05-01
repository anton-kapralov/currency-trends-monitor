package kae.demo.currencytrendsmonitor.infrastructure.persistence;

import kae.demo.currencytrendsmonitor.domain.model.trade.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/** */
public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {

  Optional<CountryEntity> findByIso2Code(String iso2Code);
}
