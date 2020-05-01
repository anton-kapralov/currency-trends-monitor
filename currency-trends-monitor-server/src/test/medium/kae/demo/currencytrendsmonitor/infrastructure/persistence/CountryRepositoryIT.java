package kae.demo.currencytrendsmonitor.infrastructure.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import kae.demo.currencytrendsmonitor.domain.model.trade.CountryEntity;
import kae.demo.currencytrendsmonitor.infrastructure.persistence.CountryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/** */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CountryRepositoryIT {

  @Autowired private CountryRepository repository;

  @Test
  public void findByIso2Code_findsCountryFromInitialData_whenValidCode() {
    Optional<CountryEntity> optionalCountry = repository.findByIso2Code("RU");

    assertThat(optionalCountry).isPresent();
    assertThat(optionalCountry.get().getName()).isEqualTo("Russia");
  }

  @Test
  public void findByIso2Code_returnsEmptyOptional_whenInvalidCode() {
    Optional<CountryEntity> optionalCountry = repository.findByIso2Code("XY");

    assertThat(optionalCountry).isEmpty();
  }
}
