package tests;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class wikipediaGettingStartedTests extends TestBase {

    @Test
    @DisplayName("First page text check")
    @Feature("Mobile Tests")
    void gettingStartedFirstPageTest() {

        step("Open first page of Getting started", () -> {
            $(MobileBy.xpath("//android.widget.HorizontalScrollView[@content-desc=\"Page 1 of 4\"]/android.widget.LinearLayout/android.widget.LinearLayout[1]")).click();
        });

        step("First page primary text check", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("The Free Encyclopedia …in over 300 languages")));
    }

    @Test
    @DisplayName("Second page text check")
    @Feature("Mobile Tests")
    void gettingStartedSecondPageTest() {

        step("Open second page of Getting started", () -> {
            $(MobileBy.xpath("//android.widget.HorizontalScrollView[@content-desc=\"Page 1 of 4\"]/android.widget.LinearLayout/android.widget.LinearLayout[2]")).click();
        });

        step("Second page primary text check", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("New ways to explore")));
    }

    @Test
    @DisplayName("Third page text check")
    @Feature("Mobile Tests")
    void gettingStartedThirdPageTest() {

        step("Open third page of Getting started", () -> {
            $(MobileBy.xpath("//android.widget.HorizontalScrollView[@content-desc=\"Page 1 of 4\"]/android.widget.LinearLayout/android.widget.LinearLayout[3]")).click();
        });

        step("Third page primary text check", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Reading lists with sync")));
    }

    @Test
    @DisplayName("Fourth page text check")
    @Feature("Mobile Tests")
    void gettingStartedFourthPageTest() {

        step("Open fourth page of Getting started", () -> {
            $(MobileBy.xpath("//android.widget.HorizontalScrollView[@content-desc=\"Page 1 of 4\"]/android.widget.LinearLayout/android.widget.LinearLayout[4]")).click();
        });
        step("Fourth page primary text check", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Send anonymous data")));
    }
}
