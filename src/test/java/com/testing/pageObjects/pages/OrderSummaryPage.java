package com.testing.pageObjects.pages;

import java.util.Map;

import io.cucumber.datatable.DataTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/order-summary")
public class OrderSummaryPage extends DeliveryMethodPage {
    public static By ORDER_SUMMARY_TITLE = text("Order Summary");
    public static By PLACE_YOUR_ORDER_AND_PAY_BUTTON = id("checkoutButton");


    public void waitForPageToLoad(){
        getElement(ORDER_SUMMARY_TITLE).waitUntilVisible();
        logWeAreOnPage();
    }
}
