package ru.softwerke.practice.app2019.model;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Bill implements Model {
    private static final String ID_FIELD = "id";
    private static final String CUSTOMER_ID_FIELD = "customerId";
    private static final String ITEMS_LIST_FIELD = "items";
    private static final String DATE_FIELD = "date";

    

    @JsonProperty(ID_FIELD)
    private UUID id;

    @JsonProperty(CUSTOMER_ID_FIELD)
    private UUID customerId;

    @JsonProperty(ITEMS_LIST_FIELD)
    private final List<Device> items;

    @JsonProperty(DATE_FIELD)
   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private final String date;

    

    @JsonIgnore
    private BigDecimal totalPrice;

  

    @JsonCreator
    public Bill(
            @NotNull @JsonProperty(value = CUSTOMER_ID_FIELD, required = true) UUID customerId,
            @NotNull @JsonProperty(value = ITEMS_LIST_FIELD, required = true) List<Device> items,
            @NotNull @JsonProperty(value = DATE_FIELD, required = true) String date){
             
    
        this.customerId = customerId;
        this.items = items;
        this.totalPrice = this.items.stream().map(Device::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        this.date = date;
        
        
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill)) return false;
        Bill bill = (Bill) o;
        return id == bill.id &&
        		customerId.equals(bill.customerId) &&
        		items.equals(bill.items) &&
        		date.equals(bill.date) &&
        		date.equals(bill.date) 
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, items, date);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", items=" + items +
                ", date=" + date +
                '}';
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public List<Device> getItems() {
        return items;
    }

    public String getDate() {
        return date;
    }

   
    
}

