package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.model.Donation;
import de.dpunkt.myaktion.model.Status;
import de.dpunkt.myaktion.services.DonationService;
import de.dpunkt.myaktion.services.DonationServiceBean;
import de.dpunkt.myaktion.util.Log;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by blackbird on 11/23/15.
 */
@ViewScoped
@Named
public class DonateMoneyController implements Serializable {

    private static final long serialVersionUID = 5493038842003809106L;
    private String textColor = "000000";
    private String bgColor = "ffffff";
    private Long campaignId;
    private Donation donation;

    @Inject
    private FacesContext facesContext;
    @Inject
    @Log.FachLog
    private Logger logger;
    @Inject
    private DonationService donationService;

    @PostConstruct
    public void initializeDonation(){
        this.donation = new Donation();
    }

    public Long getCampaignId(){
        return campaignId;
    }

    public void setCampaignId(Long campaignId){
        this.campaignId = campaignId;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    public String doDonation(){
        getDonation().setStatus(Status.IN_PROCESS);
        donationService.addDonation(getCampaignId(), getDonation());
        logger.log(Level.INFO, "log.donationMoney.thank_you",
                new Object[]{getDonation().getDonorName(),
                getDonation().getAmount()});
        final ResourceBundle resourceBundle = facesContext.getApplication().getResourceBundle(facesContext,"msg");
        final String msg = resourceBundle.getString("donateMoney.thank_you");
        facesContext.addMessage(null,new FacesMessage(
                FacesMessage.SEVERITY_INFO, msg, null));
        initializeDonation();
        return Pages.DONATE_MONEY;
    }
}
