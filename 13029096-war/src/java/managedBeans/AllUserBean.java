/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import entity.Customer;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import session.CustomerFacade;

/**
 *
 * @author Abdul Halim <13029096@studentmail.ul.ie>
 */
@Named(value = "allUserBean")
@RequestScoped
public class AllUserBean {

    @EJB
    private CustomerFacade cf;
    /**
     * Creates a new instance of AllUserBean
     */
    public AllUserBean() {
    }
    
    public List<Customer> getAllcustomers()
    {
        return cf.findAll();
    }
}
