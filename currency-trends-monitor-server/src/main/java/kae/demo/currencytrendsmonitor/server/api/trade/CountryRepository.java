package kae.demo.currencytrendsmonitor.server.api.trade;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/** */
public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {

  Optional<CountryEntity> findByIso2Code(String iso2Code);
}
