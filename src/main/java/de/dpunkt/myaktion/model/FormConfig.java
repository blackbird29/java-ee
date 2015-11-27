package de.dpunkt.myaktion.model;

import de.dpunkt.myaktion.controller.Pages;

/**
 * Created by blackbird on 11/27/15.
 */
public class FormConfig {

    private String textColor = "000000";
    private String bgColor= "ffffff";
    private String title;

    public String getTextColor(){
        return textColor;
    }

    public void setTextColor(String textColor){
        this.textColor = textColor;
    }

    public String getBgColor(){
        return textColor;
    }

    public void setBgColor(String bgColor){
        this.bgColor = bgColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
