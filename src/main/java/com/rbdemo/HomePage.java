package com.rbdemo;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public String textBox_search = "//*[@id='simple-keyword-search']";
    public String btn_searchEquipment ="//*[@id='keyword-submit']";

    public HomePage(WebDriver driver)
    {
        this.driver= driver;
    }
    public void search()
    {
        setText(textBox_search,"Ford F-150","searchBox");
        clickElement(btn_searchEquipment);
    }


}