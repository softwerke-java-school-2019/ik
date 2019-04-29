package ru.softwerke.practice.app2019.filter;


import ru.softwerke.practice.app2019.model.Bill;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
//import java.util.UUID;

public class BillFilter extends Filter{
    public final static BillFilter DF_EMPTY = new BillFilter();

    private Integer id;
    private Integer customerId;
    private Integer totalPrice;
    //private Integer purchase_totalPrice;
    private LocalDateTime purchaseDateTime;
    //private LocalDateTime tillDate;
    private Comparator<Bill> order= Comparator.comparing(Bill::getId);
   
    
    //public BillFilter(String )

    public Integer getId() {
        return id;
    }
    
    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

/*    public Integer getPurchasetotalPrice() {
        return totalPriceTo;
    }
*/
    

    public LocalDateTime getPurchaseDateTime() {
        return purchaseDateTime;
    }

    /*public LocalDateTime getTillDate() {
        return tillDate;
    }*/
    
       
    public Comparator<Bill> getOrder() {
        return order;
    }

    public BillFilter withId(Integer id) {
        this.id = id;
        return this;
    }
    
    public BillFilter withCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public BillFilter withTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    
    
    public BillFilter withPurchaseDateTime(LocalDateTime date) {
        this.purchaseDateTime = date;
        return this;
    }
    
   /* public BillFilter withTillDate(LocalDateTime date) {
        this.tillDate = date;
        return this;
    }*/

    
    public BillFilter withOrder(Comparator<Bill> order) {
        this.order = order;
        return this;
    }
    

}

