package ru.softwerke.practice.app2019.model;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.softwerke.practice.app2019.model.Model;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Customer implements Model{
    public static final String ID_FIELD = "id";
    public static final String FIRST_NAME_FIELD = "firstName";
    public static final String SECOND_NAME_FIELD = "secondName";
    public static final String THIRD_NAME_FIELD = "thirdName";
    public static final String BORN_DATE_FIELD = "bornDate";
    

    @JsonProperty(ID_FIELD)
    private UUID id;

   

    @JsonProperty(FIRST_NAME_FIELD)
    private final String firstName;

    @JsonProperty(SECOND_NAME_FIELD)
    private final String secondName;
    
    @JsonProperty(THIRD_NAME_FIELD)
    private final String thirdName;

    @JsonProperty(BORN_DATE_FIELD)
    //@XmlJavaTypeAdapter(DateManager.class)
    private final String bornDate;

    

    @JsonCreator
    public Customer(
            @NotNull @JsonProperty(BORN_DATE_FIELD) String bornDate,
            @NotNull @JsonProperty(FIRST_NAME_FIELD) String firstName,
            @NotNull @JsonProperty(SECOND_NAME_FIELD) String secondName,
            @NotNull @JsonProperty(THIRD_NAME_FIELD) String thirdName            ) {
        this.bornDate = bornDate;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getBornDate() {
        return bornDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
        		bornDate.equals(customer.bornDate) &&
        		firstName.equals(customer.firstName) &&
        		secondName.equals(customer.secondName) &&
        		thirdName.equals(customer.thirdName) 
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bornDate, firstName, secondName, thirdName);
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", borndate=" + bornDate +
                ", firstname='" + firstName + '\'' +
                ", secondname=" + secondName +
                ", thirdname=" + thirdName +
                                '}';
    }

}

