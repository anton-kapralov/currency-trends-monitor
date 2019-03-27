package kae.demo.currencytrendsmonitor.server.api.trademessage;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/** */
public final class TradeMessageTestHelper {

  public static TradeMessage createDummyTradeMessage() {
    return new TradeMessage(
        "user-1",
        "RUB",
        "USD",
        BigDecimal.valueOf(65),
        BigDecimal.ONE,
        BigDecimal.valueOf(0.0154),
        LocalDateTime.of(2019, 3, 20, 21, 12, 34),
        "RU");
  }

  private TradeMessageTestHelper() {}
}
