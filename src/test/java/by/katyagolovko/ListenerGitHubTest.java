package by.katyagolovko;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class ListenerGitHubTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String ISSUES_TAB = "Issues";
    private final static String ISSUE_NAME = "69 nice";

    @Test
    @DisplayName("Проверяем название первого Issue в списке " + ISSUE_NAME)
    public void shouldFindNameOfTheFirstIssue(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");

        $(".header-search-input").as("Строка поиска").click();
        $(".header-search-input").as("Строка поиска").setValue(REPOSITORY).submit();

        $(linkText(REPOSITORY)).as("Ссылка репозитория " + REPOSITORY).click();

        $(partialLinkText(ISSUES_TAB)).as("Issues Tab").click();

        $(linkText(ISSUE_NAME)).as("Название первой Issue " + ISSUE_NAME).isDisplayed();
    }
}
