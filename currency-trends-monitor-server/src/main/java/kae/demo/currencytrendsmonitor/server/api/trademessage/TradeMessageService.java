package kae.demo.currencytrendsmonitor.server.api.trademessage;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** */
public interface TradeMessageService {

  void save(TradeMessage tradeMessage);

  Page<TradeMessage> findAll(Pageable pageable);
}
