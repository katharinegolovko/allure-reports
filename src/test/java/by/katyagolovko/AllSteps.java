package by.katyagolovko;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class AllSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step("Находим в поиске репозиторий {repository}")
    public void findRepository(String repository){
        $(".header-search-input").click();
        $(".header-search-input").setValue(repository).submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository){
        $(linkText(repository)).click();
    }

    @Step("Переходим во вкладку {tab}")
    public void goToTab(String tab){
        $(partialLinkText(tab)).click();
        takeScreenshot();
    }

    @Step("Проверяем название первой в списке Issue")
    public void verifyNameOfTheFirstIssue(String issueName){
        $(linkText(issueName)).isDisplayed();
    }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
