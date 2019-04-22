package ru.softwerke.practice.app2019.filter;

import ru.softwerke.practice.app2019.model.Color;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class CustomerFilter implements Filter{
    public final static DeviceFilter CF_EMPTY = new DeviceFilter();

    private UUID id;
    private String bornDate;
    private String firstName;
    private String secondName;
    private String thirdName;

    public UUID getId() {
        return id;
    }

    public String getBornDate() {
        return bornDate;
    }

/*    public BigDecimal getPurchasePrice() {
        return priceTo;
    }
*/
    public String getFirstName() {
        return firstName;
    }

   
    public String getSecondName() {
        return secondName;
    }

    public String getThirdName() {
        return thirdName;
    }
    

    public CustomerFilter withId(UUID id) {
        this.id = id;
        return this;
    }

       
    public CustomerFilter withBornDate(String bornDate) {
        this.bornDate = bornDate;
        return this;
    }

    public CustomerFilter withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    
    public CustomerFilter withSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public CustomerFilter withThirdName(String thirdName) {
        this.thirdName = thirdName;
        return this;
    }

}

