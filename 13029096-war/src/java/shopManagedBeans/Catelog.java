/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopManagedBeans;

import entity.Product;
import entity.ProductCode;
import java.io.Serializable;
import java.util.*;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import session.ProductCodeFacade;
import session.ProductFacade;

/**
 *
 * @author Abdul Halim <13029096@studentmail.ul.ie>
 */
@Named(value = "catelog")
@RequestScoped
public class Catelog implements Serializable{
    
    @EJB
    private ProductFacade pf;
    
    @EJB
    private ProductCodeFacade pcf;
    
    @ManagedProperty(value = "#{param.cateId}")
    private String cateId;

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }
    /*
     * Creates a new instance of Catelog
     */
    
    public Catelog() {
    }
    
    public List<Product> getProducts()
    {
        if(cateId == null)
        {
            return pf.findAll();
        }
            
        else
        {
            return pf.getProdByCategory(cateId);
        }
    }
    
    public List<ProductCode> getProductCodeList()
    {
        return pcf.findAll();
    }
}
