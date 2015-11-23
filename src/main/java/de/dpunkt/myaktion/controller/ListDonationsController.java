package de.dpunkt.myaktion.controller;

import com.sun.tracing.dtrace.NameAttributes;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by blackbird on 11/23/15.
 */
@SessionScoped
@Named
public class ListDonationsController implements Serializable {

    private static final long serialVersionUID = 437978972432L;

    public String doOk(){
        return Pages.LIST_CAMPAIGNS;
    }

}
