package kae.demo.currencytrendsmonitor.server.api.trade;

/** */
public final class CountryTestHelper {

  public static CountryEntity createDummyCountry() {
    return new CountryEntity();
  }

  @SuppressWarnings("deprecation")
  public static CountryEntity createDummyCountry(String iso2Code) {
    return new CountryEntity(1, iso2Code, "Name of " + iso2Code);
  }

  private CountryTestHelper() {}
}
