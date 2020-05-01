package kae.demo.currencytrendsmonitor.infrastructure.persistence;

import kae.demo.currencytrendsmonitor.domain.model.trade.TradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/** */
public interface TradeRepository extends JpaRepository<TradeEntity, String> {}
