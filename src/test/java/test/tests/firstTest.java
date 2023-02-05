package test.tests;

import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class firstTest {

        public static void main(String[] args) {

            Playwright playwright = Playwright.create();
                Browser browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions().setHeadless(false)
                        );
                Page page = browser.newPage();
                page.navigate("https://letcode.in/");
                System.out.println(page.title());
                page.close();
                browser.close();
                playwright.close();
        }
}
