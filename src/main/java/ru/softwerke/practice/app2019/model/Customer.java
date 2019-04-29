package ru.softwerke.practice.app2019.model;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.softwerke.practice.app2019.model.Model;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
//import java.util.UUID;

public class Customer implements Model{
    public static final String ID_FIELD = "id";
    public static final String FIRST_NAME_FIELD = "firstName";
    public static final String MIDDLE_NAME_FIELD = "middleName";
    public static final String LAST_NAME_FIELD = "lastName";
    public static final String BIRTH_DATE_FIELD = "birthdate";
    public static final String DATE_FORMAT = "dd.MM.yyyy";
    //public static final String DATE_FORMAT = "dd-MM-yyyy";
    

    @JsonProperty(ID_FIELD)
    private Integer id;

   

    @JsonProperty(FIRST_NAME_FIELD)
    private final String firstName;

    @JsonProperty(MIDDLE_NAME_FIELD)
    private final String middleName;
    
    @JsonProperty(LAST_NAME_FIELD)
    private final String lastName;

    @JsonProperty(BIRTH_DATE_FIELD)
    //@XmlJavaTypeAdapter(DateManager.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private final LocalDate birthdate;

    

    @JsonCreator
    public Customer(
            @NotNull @JsonProperty(BIRTH_DATE_FIELD) LocalDate birthdate,
            @NotNull @JsonProperty(FIRST_NAME_FIELD) String firstName,
            @NotNull @JsonProperty(MIDDLE_NAME_FIELD) String middleName,
            @NotNull @JsonProperty(LAST_NAME_FIELD) String lastName            ) {
        this.birthdate = birthdate;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthdate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
        		birthdate.equals(customer.birthdate) &&
        		firstName.equals(customer.firstName) &&
        		middleName.equals(customer.middleName) &&
        		lastName.equals(customer.lastName) 
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, birthdate, firstName, middleName, lastName);
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", birthdate=" + birthdate +
                ", firstname='" + firstName + '\'' +
                ", middleName=" + middleName +
                ", lastName=" + lastName +
                                '}';
    }

}

