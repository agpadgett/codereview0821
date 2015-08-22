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
  public void newWordDisplayedOnIndex(){
    goTo("http://localhost:4567/words/new");
    fill("#wordname").with("thing");
    submit(".btn");
    assertThat(pageSource()).contains("thing");
  }

  @Test
  public void definitionsOfWordDisplayed(){
    goTo("http://localhost:4567/words/new");
    fill("#wordname").with("thing");
    submit(".btn");
    click("a", withText("thing"));
    assertThat(pageSource()).contains("definitions");
  }

  @Test
  public void definitionsCanBeAdded(){
    goTo("http://localhost:4567/words/new");
    fill("#wordname").with("thing");
    submit(".btn");
    click("a", withText("thing"));
    click("a", withText("add new definition"));
    fill("#newdef").with("an object");
    submit(".btn");
    assertThat(pageSource()).contains("an object");
  }

  @Test
  public void returnToWordListLinkWorks(){
    goTo("http://localhost:4567/words/new");
    fill("#wordname").with("thing");
    submit(".btn");
    click("a", withText("thing"));
    click("a", withText("return to word list"));
  }
// Jake - I had some problems with navigating from the page that lists all the definitions of a wor
}
