package kae.demo.currencytrendsmonitor.server.web.selenium;

import static kae.demo.currencytrendsmonitor.server.api.trademessage.TradeMessageTestHelper.createDummyTradeMessage;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import kae.demo.currencytrendsmonitor.server.api.trademessage.TradeMessage;
import kae.demo.currencytrendsmonitor.server.api.trademessage.TradeMessageService;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

/** */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DashboardIT {

  private WebDriver driver;

  @LocalServerPort private int port;

  @Autowired private TradeMessageService tradeMessageService;

  @BeforeClass
  public static void setUpClass() throws Exception {
    WebDriverManager.chromedriver().version("73").setup();
  }

  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
  }

  @After
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }

  @Test
  public void dashboard_showsSavedTradeMessage() {
    TradeMessage dummyTradeMessage = createDummyTradeMessage();
    dummyTradeMessage.setUserId("dashboard_showsSavedTradeMessage-1");
    tradeMessageService.save(dummyTradeMessage);
    driver.navigate().to(String.format("http://localhost:%s/", port));

    Set<String> userIds =
        driver.findElement(By.cssSelector("[data-label='trade-message-row']"))
            .findElements(By.tagName("td")).stream()
            .filter(dataLabelEqualsTo("trade-message-user-id"))
            .map(WebElement::getText)
            .collect(Collectors.toSet());

    assertThat(userIds).contains(dummyTradeMessage.getUserId());
  }

  private static Predicate<WebElement> dataLabelEqualsTo(String value) {
    return webElement -> webElement.getAttribute("data-label").equals(value);
  }
}
