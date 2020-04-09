package kae.demo.currencytrendsmonitor.server.api.trade;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZonedDateTime;
import java.util.StringJoiner;
import java.util.UUID;

/** */
@Entity
@Table(name = "trade")
public class TradeEntity implements Serializable {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private UserEntity user;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private CurrencyEntity currencyFrom;

  @Column(nullable = false)
  private BigDecimal amountFrom;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private CurrencyEntity currencyTo;

  @Column(nullable = false)
  private BigDecimal amountTo;

  @Column(nullable = false)
  private ZonedDateTime timePlaced;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private CountryEntity country;

  TradeEntity() {}

  public TradeEntity(
      UserEntity user,
      CurrencyEntity currencyFrom,
      BigDecimal amountFrom,
      CurrencyEntity currencyTo,
      BigDecimal amountTo,
      ZonedDateTime timePlaced,
      CountryEntity country) {
    this.user = user;
    this.currencyFrom = currencyFrom;
    this.amountFrom = amountFrom;
    this.currencyTo = currencyTo;
    this.amountTo = amountTo;
    this.timePlaced = timePlaced;
    this.country = country;
  }

  public String getId() {
    return id;
  }

  public UserEntity getUser() {
    return user;
  }

  public CurrencyEntity getCurrencyFrom() {
    return currencyFrom;
  }

  public BigDecimal getAmountFrom() {
    return amountFrom;
  }

  public CurrencyEntity getCurrencyTo() {
    return currencyTo;
  }

  public BigDecimal getAmountTo() {
    return amountTo;
  }

  public ZonedDateTime getTimePlaced() {
    return timePlaced;
  }

  public CountryEntity getCountry() {
    return country;
  }

  public BigDecimal getRate() {
    return amountFrom.equals(BigDecimal.ZERO)
        ? BigDecimal.ZERO
        : amountTo.divide(amountFrom, 4, RoundingMode.HALF_UP);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", TradeEntity.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("user=" + user.getSystemId())
        .add("currencyFrom=" + currencyFrom.getIsoCode())
        .add("amountFrom=" + amountFrom)
        .add("currencyTo=" + currencyTo.getIsoCode())
        .add("amountTo=" + amountTo)
        .add("timePlaced=" + timePlaced)
        .add("country=" + country.getIso2Code())
        .toString();
  }
}
