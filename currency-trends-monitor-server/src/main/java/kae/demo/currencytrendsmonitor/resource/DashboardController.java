package kae.demo.currencytrendsmonitor.resource;

import kae.demo.currencytrendsmonitor.application.TradeMessageService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/** */
@Controller
public final class DashboardController {

  private final TradeMessageService tradeMessageService;

  DashboardController(TradeMessageService tradeMessageService) {
    this.tradeMessageService = tradeMessageService;
  }

  @RequestMapping({"", "/", "/index"})
  public String getIndexPage(Model model) {
    model.addAttribute("tradeMessagesPage", tradeMessageService.findAll(PageRequest.of(0, 10)));

    return "index";
  }
}
