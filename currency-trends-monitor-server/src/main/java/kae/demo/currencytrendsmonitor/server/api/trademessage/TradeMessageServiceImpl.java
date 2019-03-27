package kae.demo.currencytrendsmonitor.server.api.trademessage;

import java.time.ZoneId;
import kae.demo.currencytrendsmonitor.server.api.trade.CountryEntity;
import kae.demo.currencytrendsmonitor.server.api.trade.CountryRepository;
import kae.demo.currencytrendsmonitor.server.api.trade.CurrencyEntity;
import kae.demo.currencytrendsmonitor.server.api.trade.CurrencyRepository;
import kae.demo.currencytrendsmonitor.server.api.trade.TradeEntity;
import kae.demo.currencytrendsmonitor.server.api.trade.TradeRepository;
import kae.demo.currencytrendsmonitor.server.api.trade.UserEntity;
import kae.demo.currencytrendsmonitor.server.api.trade.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** */
@Service
public class TradeMessageServiceImpl implements TradeMessageService {

  private static final ZoneId UTC_TIME_ZONE = ZoneId.of("UTC");

  private final CountryRepository countryRepository;
  private final CurrencyRepository currencyRepository;
  private final UserRepository userRepository;
  private final TradeRepository tradeRepository;

  public TradeMessageServiceImpl(
      CountryRepository countryRepository,
      CurrencyRepository currencyRepository,
      UserRepository userRepository,
      TradeRepository tradeRepository) {
    this.countryRepository = countryRepository;
    this.currencyRepository = currencyRepository;
    this.userRepository = userRepository;
    this.tradeRepository = tradeRepository;
  }

  @Transactional
  @Override
  public void save(TradeMessage tradeMessage) {
    CountryEntity country = getCountry(tradeMessage.getOriginatingCountry());
    CurrencyEntity currencyFrom = getCurrency(tradeMessage.getCurrencyFrom());
    CurrencyEntity currencyTo = getCurrency(tradeMessage.getCurrencyTo());
    UserEntity user = getUser(tradeMessage.getUserId());

    tradeRepository.save(
        new TradeEntity(
            user,
            currencyFrom,
            tradeMessage.getAmountSell(),
            currencyTo,
            tradeMessage.getAmountBuy(),
            tradeMessage.getTimePlaced().atZone(UTC_TIME_ZONE),
            country));
  }

  @Override
  public Page<TradeMessage> findAll(Pageable pageable) {
    return tradeRepository.findAll(pageable).map(this::toTradeMessage);
  }

  private TradeMessage toTradeMessage(TradeEntity trade) {
    return new TradeMessage(
        trade.getUser().getSystemId(),
        trade.getCurrencyFrom().getIsoCode(),
        trade.getCurrencyTo().getIsoCode(),
        trade.getAmountFrom(),
        trade.getAmountTo(),
        trade.getRate(),
        trade.getTimePlaced().toLocalDateTime(),
        trade.getCountry().getIso2Code());
  }

  private CountryEntity getCountry(String iso2Code) {
    return countryRepository
        .findByIso2Code(iso2Code)
        .orElseThrow(
            () -> new IllegalArgumentException("Country is not found by '" + iso2Code + "'"));
  }

  private CurrencyEntity getCurrency(String isoCode) {
    return currencyRepository
        .findByIsoCode(isoCode)
        .orElseThrow(
            () -> new IllegalArgumentException("Currency is not found by '" + isoCode + "'"));
  }

  private UserEntity getUser(String userId) {
    return userRepository
        .findBySystemId(userId)
        .orElseGet(() -> userRepository.save(new UserEntity(userId)));
  }
}
