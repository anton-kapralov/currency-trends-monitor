package kae.demo.currencytrendsmonitor.application;

import kae.demo.currencytrendsmonitor.application.representation.TradeMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/** */
public interface TradeMessageService {

  void save(TradeMessage tradeMessage);

  Page<TradeMessage> findAll(Pageable pageable);
}
