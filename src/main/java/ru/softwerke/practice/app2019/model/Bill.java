package ru.softwerke.practice.app2019.model;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;
//import java.util.UUID;

public class Bill implements Model {
    private static final String ID_FIELD = "id";
    private static final String CUSTOMER_ID_FIELD = "customerId";
    private static final String TOTAL_PRICE_FIELD = "totalPrice";
    private static final String ITEMS_LIST_FIELD = "items";
    private static final String PURCHASE_DATE_TIME_FIELD = "purchaseDateTime";
    public static final String DATE_FORMAT = "dd.MM.yyyy HH:mm:ss";

    

    @JsonProperty(ID_FIELD)
    private Integer id;

    @JsonProperty(CUSTOMER_ID_FIELD)
    private Integer customerId;
    
    @JsonProperty(TOTAL_PRICE_FIELD)
    private Integer totalPrice;

    @JsonProperty(ITEMS_LIST_FIELD)
    private final List<BillItem> items;

    @JsonProperty(PURCHASE_DATE_TIME_FIELD)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private final LocalDateTime purchaseDateTime;

    

   

  

    @JsonCreator
    public Bill(
            @NotNull @JsonProperty(value = CUSTOMER_ID_FIELD, required = true) Integer customerId,
            @NotNull @JsonProperty(value = ITEMS_LIST_FIELD, required = true) List<BillItem> items,
            @NotNull @JsonProperty(value = PURCHASE_DATE_TIME_FIELD, required = true) LocalDateTime purchaseDateTime){
             
    
        this.customerId = customerId;
        this.items = items;
        this.totalPrice = this.items.stream().map(BillItem::getTotalPrice).reduce( (x,y)->(x+y)).get();
        this.purchaseDateTime = purchaseDateTime;
        
        
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill)) return false;
        Bill bill = (Bill) o;
        return id == bill.id &&
        		customerId.equals(bill.customerId) &&
        		items.equals(bill.items) &&
        		purchaseDateTime.equals(bill.purchaseDateTime) &&
        		purchaseDateTime.equals(bill.purchaseDateTime) 
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, items, purchaseDateTime);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", items=" + items +
                ", purchaseDateTime=" + purchaseDateTime +
                '}';
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    
    public Integer getTotalPrice() {
        return totalPrice;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public List<BillItem> getItems() {
        return items;
    }

    public LocalDateTime getPurchaseDateTime() {
        return purchaseDateTime;
    }

   
    
}

