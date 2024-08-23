package elf.dire.tests.base_test;

import com.microsoft.playwright.*;
import elf.dire.managers.PageManager;
import elf.dire.managers.PropManager;
import org.junit.jupiter.api.*;

import static elf.dire.utils.constants.PropConst.TEST_APP_URL;

public class BaseTest {
    protected static PropManager propManager = PropManager.getPropManager();
    protected static PageManager pageManager = PageManager.getPageManager();
    protected static Playwright playwright;
    protected static Browser browser;

    protected static BrowserContext context;
    protected static Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        browser = playwright.chromium().launch();
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterAll
    static void closeBrowser() {
        context.close();
        playwright.close();
    }

    @BeforeEach
    void navigateToHomePage() {
        page.navigate(propManager.getProperty(TEST_APP_URL));
    }
}
