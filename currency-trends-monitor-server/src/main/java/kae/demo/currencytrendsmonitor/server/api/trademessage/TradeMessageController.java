package kae.demo.currencytrendsmonitor.server.api.trademessage;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** */
@RestController("/api/trademessages")
@Slf4j
public final class TradeMessageController {

  private final TradeMessageService tradeMessageService;

  TradeMessageController(TradeMessageService tradeMessageService) {
    this.tradeMessageService = tradeMessageService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity consume(@RequestBody @Valid TradeMessage tradeMessage) {
    log.debug("Received a trade message: {}", tradeMessage);

    tradeMessageService.save(tradeMessage);

    return ResponseEntity.noContent().build();
  }
}
