package de.dpunkt.myaktion.scheduler;

import de.dpunkt.myaktion.services.DonationService;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 * Created by blackbird on 1/10/16.
 */
@Singleton
public class SchedulerBean {

    @Inject
    private DonationService donationService;

    @Schedule(hour = "*", minute = "*/5", persistent = false)
    public void doTransferDonations(){
        donationService.transferDonations();
    }

}
