package kae.demo.currencytrendsmonitor.server.api.trademessage;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/** */
public final class TradeMessage {

  private String userId;

  private String currencyFrom;

  private String currencyTo;

  private BigDecimal amountSell;

  private BigDecimal amountBuy;

  private BigDecimal rate;

  @JsonDeserialize(using = TradeMessageDateTimeDeserializer.class)
  private LocalDateTime timePlaced;

  private String originatingCountry;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getCurrencyFrom() {
    return currencyFrom;
  }

  public void setCurrencyFrom(String currencyFrom) {
    this.currencyFrom = currencyFrom;
  }

  public String getCurrencyTo() {
    return currencyTo;
  }

  public void setCurrencyTo(String currencyTo) {
    this.currencyTo = currencyTo;
  }

  public BigDecimal getAmountSell() {
    return amountSell;
  }

  public void setAmountSell(BigDecimal amountSell) {
    this.amountSell = amountSell;
  }

  public BigDecimal getAmountBuy() {
    return amountBuy;
  }

  public void setAmountBuy(BigDecimal amountBuy) {
    this.amountBuy = amountBuy;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  public LocalDateTime getTimePlaced() {
    return timePlaced;
  }

  public void setTimePlaced(LocalDateTime timePlaced) {
    this.timePlaced = timePlaced;
  }

  public String getOriginatingCountry() {
    return originatingCountry;
  }

  public void setOriginatingCountry(String originatingCountry) {
    this.originatingCountry = originatingCountry;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TradeMessage)) {
      return false;
    }
    TradeMessage that = (TradeMessage) o;
    return Objects.equals(userId, that.userId)
        && Objects.equals(currencyFrom, that.currencyFrom)
        && Objects.equals(currencyTo, that.currencyTo)
        && Objects.equals(amountSell, that.amountSell)
        && Objects.equals(amountBuy, that.amountBuy)
        && Objects.equals(rate, that.rate)
        && Objects.equals(timePlaced, that.timePlaced)
        && Objects.equals(originatingCountry, that.originatingCountry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        userId,
        currencyFrom,
        currencyTo,
        amountSell,
        amountBuy,
        rate,
        timePlaced,
        originatingCountry);
  }

  @Override
  public String toString() {
    return "TradeMessage{"
        + "userId='"
        + userId
        + '\''
        + ", currencyFrom='"
        + currencyFrom
        + '\''
        + ", currencyTo='"
        + currencyTo
        + '\''
        + ", amountSell="
        + amountSell
        + ", amountBuy="
        + amountBuy
        + ", rate="
        + rate
        + ", timePlaced="
        + timePlaced
        + ", originatingCountry='"
        + originatingCountry
        + '\''
        + '}';
  }
}
