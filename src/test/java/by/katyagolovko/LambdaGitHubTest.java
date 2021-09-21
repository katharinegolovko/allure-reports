package by.katyagolovko;

import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.label;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaGitHubTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String ISSUES_TAB = "Issues";
    private final static String ISSUE_NAME = "69 nice";

    @Test
    @DisplayName("Проверяем название первого Issue " + ISSUE_NAME + " в списке ")
    public void testGithub() {
        label("owner", "katyagolovko");
        label("severity", SeverityLevel.BLOCKER.toString());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Находим в поиске репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY).submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Переходим во вкладку " + ISSUES_TAB, () -> {
            $(partialLinkText(ISSUES_TAB)).click();
        });
        step("Проверяем название первой в списке Issue", () -> {
            $(linkText(ISSUE_NAME)).isDisplayed();
        });
    }
}
