package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.data.CampaignProducer;
import de.dpunkt.myaktion.model.FormConfig;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
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
    @Inject
    private CampaignProducer campaignProducer;
    FormConfig formConfig;

    public EditDonationFormController() {
        this.formConfig = new FormConfig();
    }

    public String doOk(){
        return Pages.LIST_CAMPAIGNS;
    }

    public FormConfig getFormConfig() {
        return formConfig;
    }

    public void setFormConfig(FormConfig formConfig) {
        this.formConfig = formConfig;
    }

    public String getUrl(){
        return getAppUrl() + "/" + Pages.DONATE_MONEY + ".jsf"
                + "?bgColor=" + formConfig.getBgColor() + "&textColor=" + formConfig.getTextColor()
                + "&campaignId=" + campaignProducer.getSelectedCampaign().getId() + "&title="
                + formConfig.getTitle();
    }

    private String getAppUrl(){
        HttpServletRequest servletRequest =
                (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return servletRequest.getScheme() + "://" + servletRequest.getServerName() + ":"
                + servletRequest.getServerPort() + servletRequest.getContextPath();
    }

}
