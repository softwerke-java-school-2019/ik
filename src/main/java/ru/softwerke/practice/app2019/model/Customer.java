package ru.softwerke.practice.app2019.model;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Customer {
    public static final String ID_FIELD = "id";
    public static final String FIRST_NAME_FIELD = "firstname";
    public static final String SECOND_NAME_FIELD = "secondname";
    public static final String THIRD_NAME_FIELD = "thirdname";
    public static final String BORN_DATE_FIELD = "borndate";
    

    @JsonProperty(ID_FIELD)
    private UUID id;

   

    @JsonProperty(FIRST_NAME_FIELD)
    private final String firstname;

    @JsonProperty(SECOND_NAME_FIELD)
    private final String secondname;
    
    @JsonProperty(THIRD_NAME_FIELD)
    private final String thirdname;

    @JsonProperty(BORN_DATE_FIELD)
    @XmlJavaTypeAdapter(DateManager.class)
    private final LocalDateTime borndate;

    

    @JsonCreator
    public Customer(
            @NotNull @JsonProperty(BORN_DATE_FIELD) LocalDateTime borndate,
            @NotNull @JsonProperty(FIRST_NAME_FIELD) String firstname,
            @NotNull @JsonProperty(SECOND_NAME_FIELD) String secondname,
            @NotNull @JsonProperty(THIRD_NAME_FIELD) String thirdname            ) {
        this.borndate = borndate;
        this.firstname = firstname;
        this.secondname = secondname;
        this.thirdname = thirdname;
        
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getBornDate() {
        return borndate;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getSecondName() {
        return secondname;
    }

    public String getThirdName() {
        return thirdname;
    }

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
        		borndate.equals(customer.borndate) &&
        		firstname.equals(customer.firstname) &&
        		secondname.equals(customer.secondname) &&
        		thirdname.equals(customer.thirdname) 
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, borndate, firstname, secondname, thirdname);
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", borndate=" + borndate +
                ", firstname='" + firstname + '\'' +
                ", secondname=" + secondname +
                ", thirdname=" + thirdname +
                                '}';
    }

}

