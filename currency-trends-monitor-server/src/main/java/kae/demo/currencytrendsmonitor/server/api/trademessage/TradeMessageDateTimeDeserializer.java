package kae.demo.currencytrendsmonitor.server.api.trademessage;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.time.format.DateTimeFormatterBuilder;

/** */
public class TradeMessageDateTimeDeserializer extends LocalDateTimeDeserializer {

  public TradeMessageDateTimeDeserializer() {
    super(
        new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("dd-MMM-yy HH:mm:ss")
            .toFormatter());
  }
}
