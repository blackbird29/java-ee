package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.data.CampaignProducer;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * Created by blackbird on 11/23/15.
 */
@ViewScoped
@Named
public class EditDonationFormController implements Serializable {

    private static final long serialVersionUID = -4210085665488144340L;
    private String textColor = "000000";
    private String bgColor= "ffffff";
    @Inject
    private CampaignProducer campaignProducer;
    @Inject
    private HttpServletRequest request;

    public String doOk(){
        return Pages.LIST_CAMPAIGNS;
    }

    public String getUrl(){
        return getAppUrl() + "/" + Pages.DONATE_MONEY + ".jsf"
                + "?bgColor=" + bgColor + "&textColor=" + textColor
                + "&campaignId=" + campaignProducer.getSelectedCampaign().getId();
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

    private String getAppUrl(){
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String contextPath = request.getContextPath();

        return scheme+"://"+serverName+":"+serverPort+contextPath;
    }

}
