package ru.softwerke.practice.app2019.memory;

import ru.softwerke.practice.app2019.model.Color;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class DeviceFilter {
    public final static DeviceFilter EMPTY = new DeviceFilter();

    private UUID id;
    private BigDecimal price;
    //private BigDecimal purchase_price;
    private String model;
    private Color color;
    private LocalDateTime date;
    private String manufacturer;

    public UUID getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

/*    public BigDecimal getPurchasePrice() {
        return priceTo;
    }
*/
    public String getModel() {
        return model;
    }

    public Color getColor() {
        return color;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public DeviceFilter withId(UUID id) {
        this.id = id;
        return this;
    }

    public DeviceFilter withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    
    public DeviceFilter withModel(String model) {
        this.model = model;
        return this;
    }

    public DeviceFilter withColor(Color color) {
        this.color = color;
        return this;
    }

    public DeviceFilter withDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public DeviceFilter withManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

}
