package com.rbdemo;

import org.openqa.selenium.WebDriver;



public class ResultsPage extends  BasePage {
    public String search_results = "//*[@id=\"lblShowResultsFor\"]/p";
    public String first_searchResult = "(//*[@id=\"searchResultsList\"]//main//h3)[1]";
    public String txtBox_manufacturerYear_Start = "//div[@id=\"manufacturer_year_dt\"]//input[1]";
    public String txtBox_manufacturerYear_End = "//div[@id=\"manufacturer_year_dt\"]//input[2]";

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setManufacturingYearBegin() {
        verifyElementPresent(txtBox_manufacturerYear_Start);
        setText(txtBox_manufacturerYear_Start, "2010", "manufacturer_year_dt");
   }

    public void setManufacturingYearEnd() {

        verifyElementPresent(txtBox_manufacturerYear_End);
        setText(txtBox_manufacturerYear_End, "2023", "manufacturer_year_dt");

    }

    public String getSearchResult() {
        String searchResultsMessage = getMessage(search_results);
        String words[] = searchResultsMessage.split(" ");
        return words[1];
    }

    public String getFirstResultHeader(){
        String firstResult = getMessage(first_searchResult);
        System.out.println("First record from the search results list is " + firstResult);
        return firstResult;
    }



}

