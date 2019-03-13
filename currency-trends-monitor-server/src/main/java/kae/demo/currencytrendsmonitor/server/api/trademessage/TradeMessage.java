package kae.demo.currencytrendsmonitor.server.api.trademessage;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.Data;

/** */
@Data
public final class TradeMessage {

  private String userId;

  private String currencyFrom;

  private String currencyTo;

  private BigDecimal amountSell;

  private BigDecimal amountBuy;

  private BigDecimal rate;

  private ZonedDateTime dateTime;

  private String originatingCountry;
}
