package kae.demo.currencytrendsmonitor.server.api.trademessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/** */
@RestController("/api/trademessages")
public final class TradeMessageController {

  private static final Logger log = LoggerFactory.getLogger(TradeMessageController.class);

  private final TradeMessageService tradeMessageService;

  TradeMessageController(TradeMessageService tradeMessageService) {
    this.tradeMessageService = tradeMessageService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> consume(@RequestBody @Valid TradeMessage tradeMessage) {
    log.debug("Received a trade message: {}", tradeMessage);

    tradeMessageService.save(tradeMessage);

    return ResponseEntity.noContent().build();
  }
}
