package elf.dire.managers;

import com.microsoft.playwright.Page;
import elf.dire.pages.FoodPage;
import elf.dire.pages.ModalWindow;
import elf.dire.pages.HomePage;

public class PageManager {
    private static PageManager pageManager;
    private HomePage homePage;
    private FoodPage foodPage;
    private ModalWindow modalWindow;

    // Private constructor to prevent instantiation from other classes
    private PageManager() {}

    /**
     * Returns the singleton instance of PageManager. If it doesn't exist, a new instance is created.
     * @return the singleton instance of PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Returns the HomePage instance. If it doesn't exist, a new HomePage is initialized.
     * @return the HomePage instance
     */
    public HomePage getHomePage(Page page) {
        if (homePage == null) {
            homePage = new HomePage(page);
        }
        return homePage;
    }

    /**
     * Returns the FoodPage instance. If it doesn't exist, a new FoodPage is initialized.
     * @return the FoodPage instance
     */
    public FoodPage getFoodPage(Page page) {
        if (foodPage == null) {
            foodPage = new FoodPage(page);
        }
        return foodPage;
    }

    /**
     * Returns the ModalWindow instance. If it doesn't exist, a new ModalWindow is initialized.
     * @return the ModalWindow instance
     */
    public ModalWindow getModalWindow(Page page) {
        if (modalWindow == null) {
            modalWindow = new ModalWindow(page);
        }
        return modalWindow;
    }
}
