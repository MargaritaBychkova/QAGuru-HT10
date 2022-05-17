package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

    }

    @AfterEach
    void addAttachments (){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();

    }
}
