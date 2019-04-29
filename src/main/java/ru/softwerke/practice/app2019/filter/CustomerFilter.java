package ru.softwerke.practice.app2019.filter;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
//import java.util.UUID;

import ru.softwerke.practice.app2019.model.Customer;
import ru.softwerke.practice.app2019.model.Device;

public class CustomerFilter extends Filter{
    public final static DeviceFilter CF_EMPTY = new DeviceFilter();

    private Integer id;
    private LocalDate birthdate;
    private String firstName;
    private String middleName;
    private String lastName;
    private Comparator<Customer> order= Comparator.comparing(Customer::getId);

    public Integer getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthdate;
    }

/*    public BigDecimal getPurchasePrice() {
        return priceTo;
    }
*/
    public String getFirstName() {
        return firstName;
    }

   
    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public Comparator<Customer> getOrder() {
        return order;
    }
    

    public CustomerFilter withId(Integer id) {
        this.id = id;
        return this;
    }

       
    public CustomerFilter withBirthDate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public CustomerFilter withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    
    public CustomerFilter withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public CustomerFilter withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    
    public CustomerFilter withOrder(Comparator<Customer> order) {
        this.order = order;
        return this;
    }

}

