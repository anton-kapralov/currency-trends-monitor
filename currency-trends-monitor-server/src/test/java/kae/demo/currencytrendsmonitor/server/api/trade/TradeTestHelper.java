package kae.demo.currencytrendsmonitor.server.api.trade;

import static kae.demo.currencytrendsmonitor.server.api.trade.CountryTestHelper.createDummyCountry;
import static kae.demo.currencytrendsmonitor.server.api.trade.CurrencyTestHelper.createDummyCurrency;

import java.time.ZoneId;
import kae.demo.currencytrendsmonitor.server.api.trademessage.TradeMessage;

/** */
public final class TradeTestHelper {

  public static TradeEntity createDummyTrade(TradeMessage tradeMessage) {
    return new TradeEntity(
        new UserEntity(tradeMessage.getUserId()),
        createDummyCurrency(tradeMessage.getCurrencyFrom()),
        tradeMessage.getAmountSell(),
        createDummyCurrency(tradeMessage.getCurrencyTo()),
        tradeMessage.getAmountBuy(),
        tradeMessage.getTimePlaced().atZone(ZoneId.of("UTC")),
        createDummyCountry(tradeMessage.getOriginatingCountry()));
  }

  private TradeTestHelper() {}
}
