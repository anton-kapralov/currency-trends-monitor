package kae.demo.currencytrendsmonitor.server.api.trade;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/** */
public interface TradeRepository extends JpaRepository<TradeEntity, String> {}
