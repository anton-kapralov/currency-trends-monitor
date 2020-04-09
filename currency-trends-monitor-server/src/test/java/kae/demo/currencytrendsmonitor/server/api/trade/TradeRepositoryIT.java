package kae.demo.currencytrendsmonitor.server.api.trade;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/** */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TradeRepositoryIT {

  @Autowired private TestEntityManager em;

  @Autowired private TradeRepository tradeRepository;
  @Autowired private CountryRepository countryRepository;
  @Autowired private CurrencyRepository currencyRepository;

  @After
  public void tearDown() {
    tradeRepository.deleteAll();
  }

  @Test
  public void findById_returnsPersistedTrade() {
    String id = em.persist(createDummyTradeEntity()).getId();

    Optional<TradeEntity> optionalUser = tradeRepository.findById(id);

    assertThat(optionalUser).isPresent();
    assertThat(optionalUser.get().getId()).isEqualTo(id);
  }

  private TradeEntity createDummyTradeEntity() {
    UserEntity user = em.persist(new UserEntity("user-1"));
    //noinspection OptionalGetWithoutIsPresent
    return new TradeEntity(
        user,
        currencyRepository.findByIsoCode("RUB").get(),
        BigDecimal.valueOf(65),
        currencyRepository.findByIsoCode("USD").get(),
        BigDecimal.ONE,
        ZonedDateTime.of(2019, 3, 20, 20, 12, 34, 0, ZoneId.of("Europe/Moscow")),
        countryRepository.findByIso2Code("RU").get());
  }
}
