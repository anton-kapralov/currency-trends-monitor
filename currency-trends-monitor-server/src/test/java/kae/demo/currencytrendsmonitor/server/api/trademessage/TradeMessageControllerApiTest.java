package kae.demo.currencytrendsmonitor.server.api.trademessage;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONException;
import org.json.JSONObject;
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
                .content(createDummyTradeMessageJsonObject().toString()))
        .andExpect(status().isNoContent());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenAbsentUserId() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().remove("userId").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenEmptyUserId() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().put("userId", "").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenAbsentCurrencyFrom() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().remove("currencyFrom").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenEmptyCurrencyFrom() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().put("currencyFrom", "").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenInvalidCurrencyFromSize() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().put("currencyFrom", "x").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenAbsentCurrencyTo() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().remove("currencyTo").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenEmptyCurrencyTo() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().put("currencyTo", "").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenInvalidCurrencyToSize() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().put("currencyTo", "x").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenAbsentAmountSell() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().remove("amountSell").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenZeroAmountSell() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().put("amountSell", "0").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenNegativeAmountSell() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().put("amountSell", "-1").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenAbsentAmountBuy() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().remove("amountBuy").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenZeroAmountBuy() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().put("amountBuy", "0").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenNegativeAmountBuy() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().put("amountBuy", "-1").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenAbsentRate() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().remove("rate").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenZeroRate() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().put("rate", "0").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenNegativeRate() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().put("rate", "-1").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenTimePlaced() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(createDummyTradeMessageJsonObject().remove("timePlaced").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenAbsentOriginatingCountry()
      throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(
                    createDummyTradeMessageJsonObject().remove("originatingCountry").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenEmptyOriginatingCountry() throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(
                    createDummyTradeMessageJsonObject().put("originatingCountry", "").toString()))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void postApiTradeMessage_returnsBadRequest_whenInvalidOriginatingCountrySize()
      throws Exception {
    mockMvc
        .perform(
            post("/api/trademessages")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(
                    createDummyTradeMessageJsonObject().put("originatingCountry", "x").toString()))
        .andExpect(status().isBadRequest());
  }

  private static JSONObject createDummyTradeMessageJsonObject() throws JSONException {
    return new JSONObject()
        .put("userId", "134256")
        .put("currencyFrom", "EUR")
        .put("currencyTo", "GBP")
        .put("amountSell", 1000)
        .put("amountBuy", 747.10)
        .put("rate", 0.7471)
        .put("timePlaced", "24-JAN-15 10:27:44")
        .put("originatingCountry", "FR");
  }
}
