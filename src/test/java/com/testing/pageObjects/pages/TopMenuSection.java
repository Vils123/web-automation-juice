package com.testing.pageObjects.pages;

import static org.junit.Assert.fail;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.WebElementFacade;

public class TopMenuSection extends BasePage {
  // Locators
  // -------------------------------------------------------------------------------------------------------------------
  public static By ACCOUNT_BUTTON;
  public static By LOGIN_BUTTON;
  public static By SEARCH_ICON;
  public static By SEARCH_FIELD;
  public static By SHOPPING_CART_BUTTON;
  public static By CHOOSE_LANGUAGE_BUTTON;
  public static By LANGUAGE_LIST;
  public static By ORDERS_AND_PAYMENT_OPTION;
  public static By PRIVACY_AND_SECURITY_OPTION;
  public static By LOGOUT_BUTTON;
  public static By CHANGE_PASSWORD_BUTTON;
  public static By DIGITAL_WALLET_OPTION;

  // Public methods
  // -------------------------------------------------------------------------------------------------------------------
  public void searchFor(String string){
    info("Searching for: " + string);
    getElement(SEARCH_ICON).click();
    getElement(SEARCH_FIELD).sendKeys(string);
    getElement(SEARCH_FIELD).sendKeys(Keys.ENTER);
  }

  public void performSelectLanguage(DataTable data){
    info("Selecting language");
    String language = null;
    Boolean found = null;

    getElement(CHOOSE_LANGUAGE_BUTTON).click();

    for (Map<String, String> map : dataToMap(data)) {
      language = map.get("Language");
      found = false;

      for (WebElementFacade element : getElements(LANGUAGE_LIST)) {
        if(!element.getText().contains(language)) continue;
        scrollIntoView(element);
        element.click();
        found = true;
        break;
      }
    }
    if(found) return;
    fail("Failed to set given languge: " + language);
  }
}
