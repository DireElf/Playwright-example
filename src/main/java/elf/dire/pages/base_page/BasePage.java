package elf.dire.pages.base_page;


import com.microsoft.playwright.Page;
import elf.dire.managers.PageManager;

public class BasePage {
    protected PageManager pageManager = PageManager.getPageManager();
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

}
