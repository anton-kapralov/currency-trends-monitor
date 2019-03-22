package kae.demo.currencytrendsmonitor.server.api.trade;

/** */
public final class CurrencyTestHelper {

  public static CurrencyEntity createDummyCurrency() {
    return new CurrencyEntity();
  }

  @SuppressWarnings("deprecation")
  public static CurrencyEntity createDummyCurrency(String isoCode) {
    return new CurrencyEntity(1, isoCode, "Name of " + isoCode);
  }

  private CurrencyTestHelper() {}
}
