package test.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class firstTest {

        public static void main(String[] args) {

            Playwright playwright = Playwright.create();
                Browser browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions().setHeadless(false)
                        );
                Page page = browser.newPage();
                page.navigate("http://playwright.dev");
                System.out.println(page.title());
                System.out.println(page.url());


                assertThat(page).hasTitle(Pattern.compile("Playwright"));

                Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));
                assertThat(getStarted).hasAttribute("href", "/docs/intro");
                getStarted.click();
                assertThat(page).hasURL(Pattern.compile(".*intro"));
                page.close();
                browser.close();
                playwright.close();
        }
}
