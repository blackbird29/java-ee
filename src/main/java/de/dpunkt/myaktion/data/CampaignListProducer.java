package de.dpunkt.myaktion.data;

import de.dpunkt.myaktion.model.Account;
import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.model.Donation;
import de.dpunkt.myaktion.model.Status;
import de.dpunkt.myaktion.util.Events;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Decorated;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by blackbird on 10/28/15.
 */
@SessionScoped
public class CampaignListProducer implements Serializable {

    private static final long serialVersionUID = -182866064791747156L;
    private List<Campaign> campaigns;

    @PostConstruct
    public void initializeCampaigns(){
        campaigns = createMockCampaigns();
    }

    @Produces
    @Named
    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void onCampaignAdded(@Observes @Events.Added Campaign campaign){
        getCampaigns().add(campaign);
    }

    public void onCampaignDeleted(@Observes @Events.Deleted Campaign campaign){
        getCampaigns().remove(campaign);
    }

    private List<Campaign> createMockCampaigns() {
        Donation donation1 = new Donation();
        donation1.setDonorName("Heinz Schmidt");
        donation1.setAmount(20d);
        donation1.setReceiptRequested(true);
        donation1.setStatus(Status.TRANSFERRED);
        donation1.setAccount(new Account(donation1.getDonorName(),
                "XXX Bank", "DE44876543210000123456"));

        Donation donation2 = new Donation();
        donation2.setDonorName("Karl Meier");
        donation2.setAmount(30d);
        donation2.setReceiptRequested(false);
        donation2.setStatus(Status.IN_PROCESS);
        donation2.setAccount(new Account(donation2.getDonorName(),
                "YYY Bank", "DE44864275310000654321"));

        List<Donation> donations = new LinkedList<>();
        donations.add(donation1);
        donations.add(donation2);

        Campaign campaign1 = new Campaign();
        campaign1.setName("Trikots für A-Jugend");
        campaign1.setTargetAmount(1000d);
        campaign1.setAmountDonatedSoFar(258d);
        campaign1.setDonationMinimum(20d);
        campaign1.setId(1L);

        campaign1.setAccount( new Account("Max Mustermann", "ABC Bank",
                "DE44123456780100200300"));

        campaign1.setDonations(donations);

        Campaign campaign2 = new Campaign();
        campaign2.setName("Rollstuhl für Maria");
        campaign2.setTargetAmount(2500d);
        campaign2.setAmountDonatedSoFar(742d);
        campaign2.setDonationMinimum(25d);
        campaign2.setId(2L);
        campaign2.setAccount(campaign1.getAccount());
        campaign2.setDonations(donations);
        List<Campaign> returnList = new LinkedList<>();
        returnList.add(campaign1);
        returnList.add(campaign2);

        return returnList;

    }
}
