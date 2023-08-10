package tests;

import io.appium.java_client.MobileBy;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;

public class voiceSearchButtonTest extends TestBase {

    @Test
    @DisplayName("Voice search working")
    @AllureId("25135")
    @Feature("Mobile Tests")
    void voiceSearchButtonTest() {

        back();

        step("Press Voice Search button", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/voice_search_button")).click();
        });

        step("Verify button works", () ->
                $(MobileBy.id("com.google.android.tts:id/transcription_intent_api_text"))
                        .shouldHave(text("Try saying something")));
    }
}

