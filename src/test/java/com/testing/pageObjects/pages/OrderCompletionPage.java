package com.testing.pageObjects.pages;

import java.util.Map;

import io.cucumber.datatable.DataTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/order-completion")
public class OrderCompletionPage extends OrderSummaryPage {
   public static By ORDER_COMPLETE_TITLE = text("Thank you for your purchase!");

   public void waitForPageToLoad(){
      getElement(ORDER_COMPLETE_TITLE).waitUntilVisible();
      logWeAreOnPage();
   }
}
