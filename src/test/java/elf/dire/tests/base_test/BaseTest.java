package elf.dire.tests.base_test;

import com.microsoft.playwright.*;
import elf.dire.managers.PageManager;
import elf.dire.managers.PropManager;
import org.junit.jupiter.api.*;

public class BaseTest {
    protected static PropManager propManager = PropManager.getPropManager();
    protected static PageManager pageManager = PageManager.getPageManager();
    protected static Playwright playwright;
    protected static Browser browser;

    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }
}
