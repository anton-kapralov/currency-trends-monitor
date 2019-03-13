package kae.demo.currencytrendsmonitor.server.api.trademessage;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/** */
@RunWith(SpringRunner.class)
@WebMvcTest(TradeMessageController.class)
public class TradeMessageControllerApiTest {

  @Autowired private MockMvc mockMvc;

  @Test
  public void postApiTradeMessage_returnsNoContent_whenValidTradeMessage() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessage()))
        .andExpect(status().isNoContent());
  }

  private static String createDummyTradeMessage() {
    return "{\n"
        + "    \"userId\": \"134256\", \n"
        + "    \"currencyFrom\": \"EUR\", \n"
        + "    \"currencyTo\": \"GBP\", \n"
        + "    \"amountSell\": 1000, \n"
        + "    \"amountBuy\": 747.10, \n"
        + "    \"rate\": 0.7471, \n"
        + "    \"timePlaced\" : \"24-JAN-15 10:27:44\", \n"
        + "    \"originatingCountry\" : \"FR\"\n"
        + "}";
  }
}
