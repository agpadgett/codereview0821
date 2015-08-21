import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest{
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Make a Dictionary");
  }

  @Test
  public void wordIsCreated(){
    goTo("http://localhost:4567/");
    click("a", withText("add a new word"));
    fill("#wordname").with("thing");
    submit(".btn");
    assertThat(pageSource()).contains("your word has been saved");
  }

  @Test
  public void newWordDisplayedOnIndex(){
    goTo("http://localhost:4567/words/new");
    fill("#wordname").with("thing");
    submit(".btn");
    click("a", withText("view words"));
    assertThat(pageSource()).contains("thing");
  }

  @Test
  public void definitionsOfWordDisplayed(){
    goTo("http://localhost:4567/words/new");
    fill("#wordname").with("thing");
    submit(".btn");
    click("a", withText("view words"));
    click("a", withText("thing"));
    assertThat(pageSource()).contains("definitions");
  }


}
