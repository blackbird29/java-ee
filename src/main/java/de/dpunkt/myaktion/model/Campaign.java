package de.dpunkt.myaktion.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by blackbird on 10/18/15.
 */
@NamedQueries({
        @NamedQuery(
                name = Campaign.findByOrganizer,
                query = "SELECT c FROM Campaign c WHERE c.organizer = :organizer ORDER BY c.name"
        ),
        @NamedQuery(
                name = Campaign.findAll,
                query = "SELECT c FROM Campaign c ORDER BY c.name"),
        @NamedQuery(
                name = Campaign.getAmountDonatedSoFar,
                query = "SELECT SUM(d.amount) FROM Donation d WHERE d.campaign = :campaign")
})

@Entity
public class Campaign {

    @GeneratedValue
    @Id
    private Long id;

    public static final String findByOrganizer = "Campaign.findByOrganizer";
    public static final String findAll = "Campaign.findAll";
    public static final String getAmountDonatedSoFar = "Campaign.getAmountDonatedSoFar";

    @NotNull
    @Size(min = 4, max = 30, message = "{campaign.name.size}")
    private String name;
    @NotNull(message = "{campaign.targetAmount.notNull}")
    @DecimalMin(value = "10.00", message = "{campaign.targetAmount.decimalMin}")
    private Double targetAmount;
    @NotNull(message = "{campaign.donationMinimum.notNull}")
    @DecimalMin(value = "1.00", message = "{campaign.donationMinimum.decimalMin}")
    private Double donationMinimum;
    @Transient
    private Double amountDonatedSoFar;
    @AttributeOverrides({@AttributeOverride(name = "name", column = @Column(name = "accountName"))})
    @Embedded
    private Account account;
    @OneToMany(mappedBy = "campaign", cascade = CascadeType.REMOVE)
    private List<Donation> donations;
    private String currency = "EUR";
    @ManyToOne
    private Organizer organizer;

    public Campaign() {
        this.account = new Account();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Double getDonationMinimum() {
        return donationMinimum;
    }

    public void setDonationMinimum(Double donationMinimun) {
        this.donationMinimum = donationMinimun;
    }

    public Double getAmountDonatedSoFar() {
        return amountDonatedSoFar;
    }

    public void setAmountDonatedSoFar(Double amountDonatedSoFar) {
        this.amountDonatedSoFar = amountDonatedSoFar;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public String getCurrency(){
        return currency;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }
}
