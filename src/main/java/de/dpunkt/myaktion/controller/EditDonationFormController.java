package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.data.CampaignProducer;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.io.StringReader;

/**
 * Created by blackbird on 11/23/15.
 */
@SessionScoped
@Named
public class EditDonationFormController implements Serializable {

    private static final long serialVersionUID = -4210085665488144340L;
    private String textColor = "000000";
    private String bgColor= "ffffff";
    @Inject
    private CampaignProducer campaignProducer;

    public String doOk(){
        return Pages.LIST_CAMPAIGNS;
    }

    public String getUrl(){
        return "http://localhost:8080/my-aktion/donateMoney.jsf?bgColor="
                +bgColor + "&textColor=" + textColor + "&campaignId"
                +campaignProducer.getSelectedCampaign().getId();
    }

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

}
