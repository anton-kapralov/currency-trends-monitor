package kae.demo.currencytrendsmonitor.server.api.trademessage;

import static kae.demo.currencytrendsmonitor.server.api.trade.CountryTestHelper.createDummyCountry;
import static kae.demo.currencytrendsmonitor.server.api.trade.CurrencyTestHelper.createDummyCurrency;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import kae.demo.currencytrendsmonitor.server.api.trade.CountryEntity;
import kae.demo.currencytrendsmonitor.server.api.trade.CountryRepository;
import kae.demo.currencytrendsmonitor.server.api.trade.CurrencyEntity;
import kae.demo.currencytrendsmonitor.server.api.trade.CurrencyRepository;
import kae.demo.currencytrendsmonitor.server.api.trade.TradeRepository;
import kae.demo.currencytrendsmonitor.server.api.trade.UserEntity;
import kae.demo.currencytrendsmonitor.server.api.trade.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/** */
public class TradeMessageServiceImplTest {

  @Mock private CountryRepository countryRepository;
  @Mock private CurrencyRepository currencyRepository;
  @Mock private UserRepository userRepository;
  @Mock private TradeRepository tradeRepository;

  @InjectMocks private TradeMessageServiceImpl tradeMessageService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);

    when(countryRepository.findByIso2Code(any())).thenReturn(Optional.of(createDummyCountry()));
    when(currencyRepository.findByIsoCode(any())).thenReturn(Optional.of(createDummyCurrency()));
    when(currencyRepository.findByIsoCode(any())).thenReturn(Optional.of(createDummyCurrency()));
    when(userRepository.save(any())).then(returnsFirstArg());
  }

  @Test
  public void save_findsUser_whenKnownSystemId() {
    TradeMessage tradeMessage = createDummyTradeMessage();
    UserEntity dummyUser = new UserEntity(tradeMessage.getUserId());
    when(userRepository.findBySystemId(tradeMessage.getUserId()))
        .thenReturn(Optional.of(dummyUser));

    tradeMessageService.save(tradeMessage);

    verify(tradeRepository).save(argThat(tradeEntity -> tradeEntity.getUser().equals(dummyUser)));
  }

  @Test
  public void save_createsNewUser_whenUnknownSystemId() {
    TradeMessage tradeMessage = createDummyTradeMessage();
    UserEntity dummyUser = new UserEntity(tradeMessage.getUserId());
    when(userRepository.save(eq(dummyUser))).then(returnsFirstArg());

    tradeMessageService.save(tradeMessage);

    verify(tradeRepository).save(argThat(tradeEntity -> tradeEntity.getUser().equals(dummyUser)));
  }

  @Test
  public void save_findsCurrencyFromByIsoCode() {
    TradeMessage tradeMessage = createDummyTradeMessage();
    CurrencyEntity dummyCurrencyFrom = createDummyCurrency(tradeMessage.getCurrencyFrom());
    when(currencyRepository.findByIsoCode(tradeMessage.getCurrencyFrom()))
        .thenReturn(Optional.of(dummyCurrencyFrom));

    tradeMessageService.save(tradeMessage);

    verify(tradeRepository)
        .save(argThat(tradeEntity -> tradeEntity.getCurrencyFrom().equals(dummyCurrencyFrom)));
  }

  @Test
  public void save_throwsIae_whenDoesNotFoundCurrencyFromByIsoCode() {
    TradeMessage tradeMessage = createDummyTradeMessage();
    when(currencyRepository.findByIsoCode(tradeMessage.getCurrencyFrom()))
        .thenReturn(Optional.empty());

    Throwable throwable = catchThrowable(() -> tradeMessageService.save(tradeMessage));

    assertThat(throwable)
        .isInstanceOf(IllegalArgumentException.class)
        .hasNoCause()
        .hasMessage("Currency is not found by '" + tradeMessage.getCurrencyFrom() + "'");
  }

  @Test
  public void save_usesAmountSellAsAmountFrom() {
    TradeMessage tradeMessage = createDummyTradeMessage();

    tradeMessageService.save(tradeMessage);

    verify(tradeRepository)
        .save(
            argThat(
                tradeEntity -> tradeEntity.getAmountFrom().equals(tradeMessage.getAmountSell())));
  }

  @Test
  public void save_findsCurrencyToByIsoCode() {
    TradeMessage tradeMessage = createDummyTradeMessage();
    CurrencyEntity dummyCurrencyTo = createDummyCurrency(tradeMessage.getCurrencyTo());
    when(currencyRepository.findByIsoCode(tradeMessage.getCurrencyTo()))
        .thenReturn(Optional.of(dummyCurrencyTo));

    tradeMessageService.save(tradeMessage);

    verify(tradeRepository)
        .save(argThat(tradeEntity -> tradeEntity.getCurrencyTo().equals(dummyCurrencyTo)));
  }

  @Test
  public void save_throwsIae_whenDoesNotFoundCurrencyToByIsoCode() {
    TradeMessage tradeMessage = createDummyTradeMessage();
    when(currencyRepository.findByIsoCode(tradeMessage.getCurrencyTo()))
        .thenReturn(Optional.empty());

    Throwable throwable = catchThrowable(() -> tradeMessageService.save(tradeMessage));

    assertThat(throwable)
        .isInstanceOf(IllegalArgumentException.class)
        .hasNoCause()
        .hasMessage("Currency is not found by '" + tradeMessage.getCurrencyTo() + "'");
  }

  @Test
  public void save_usesAmountBuyAsAmountTo() {
    TradeMessage tradeMessage = createDummyTradeMessage();

    tradeMessageService.save(tradeMessage);

    verify(tradeRepository)
        .save(
            argThat(
                tradeEntity -> tradeEntity.getAmountFrom().equals(tradeMessage.getAmountSell())));
  }

  @Test
  public void save_findsCountryByIso2Code() {
    TradeMessage tradeMessage = createDummyTradeMessage();
    CountryEntity dummyCountry = createDummyCountry(tradeMessage.getOriginatingCountry());
    when(countryRepository.findByIso2Code(tradeMessage.getOriginatingCountry()))
        .thenReturn(Optional.of(dummyCountry));

    tradeMessageService.save(tradeMessage);

    verify(tradeRepository)
        .save(argThat(tradeEntity -> tradeEntity.getCountry().equals(dummyCountry)));
  }

  @Test
  public void save_usesUtcTimeZone() {
    TradeMessage tradeMessage = createDummyTradeMessage();
    ZonedDateTime timePlacedAtUtc = tradeMessage.getTimePlaced().atZone(ZoneId.of("UTC"));

    tradeMessageService.save(tradeMessage);

    verify(tradeRepository)
        .save(argThat(tradeEntity -> tradeEntity.getTimePlaced().equals(timePlacedAtUtc)));
  }

  private TradeMessage createDummyTradeMessage() {
    return new TradeMessage(
        "user-1",
        "RUB",
        "USD",
        BigDecimal.valueOf(65),
        BigDecimal.ONE,
        BigDecimal.valueOf(65),
        LocalDateTime.of(2019, 3, 20, 21, 12, 34),
        "RU");
  }
}
