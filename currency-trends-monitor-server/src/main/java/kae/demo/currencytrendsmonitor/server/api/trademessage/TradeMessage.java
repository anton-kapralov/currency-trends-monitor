package kae.demo.currencytrendsmonitor.server.api.trademessage;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Data;

/** */
@Data
@Builder
public final class TradeMessage {

  private String userId;

  private String currencyFrom;

  private String currencyTo;

  private BigDecimal amountSell;

  private BigDecimal amountBuy;

  private BigDecimal rate;

  private ZonedDateTime timePlaced;

  private String originatingCountry;
}
