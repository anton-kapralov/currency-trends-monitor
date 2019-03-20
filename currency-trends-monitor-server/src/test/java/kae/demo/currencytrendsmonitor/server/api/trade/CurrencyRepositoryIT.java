package kae.demo.currencytrendsmonitor.server.api.trade;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/** */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CurrencyRepositoryIT {

  @Autowired private CurrencyRepository repository;

  @Test
  public void findByIsoCode_returnsCurrencyFromInitialData_whenValidCode() {
    Optional<CurrencyEntity> optionalCurrency = repository.findByIsoCode("RUB");

    assertThat(optionalCurrency).isPresent();
    assertThat(optionalCurrency.get().getName()).isEqualTo("Russian Ruble");
  }

  @Test
  public void findByIso2Code_returnsEmptyOptional_whenInvalidCode() {
    Optional<CurrencyEntity> optionalCurrency = repository.findByIsoCode("XYZ");

    assertThat(optionalCurrency).isEmpty();
  }
}
