package ru.softwerke.practice.app2019.filter;

import ru.softwerke.practice.app2019.model.ColorName;
import ru.softwerke.practice.app2019.model.ColorRGB;
import ru.softwerke.practice.app2019.model.DeviceTypeName;
import ru.softwerke.practice.app2019.model.Device;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
//import java.util.UUID;

public class DeviceFilter extends Filter{
    public final static DeviceFilter DF_EMPTY = new DeviceFilter();

    private Integer id;
    private Integer price;
    //private Integer purchase_price;
    private String modelName;
    private DeviceTypeName deviceType;
    private ColorName colorName;
    private ColorRGB colorRGB;
    private LocalDate sinceDate;
    private LocalDate tillDate;
    private String manufacturer;
    private Comparator<Device> order= Comparator.comparing(Device::getId);
   
    
    //public DeviceFilter(String )

    public Integer getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

/*    public Integer getPurchasePrice() {
        return priceTo;
    }
*/
    public String getModelName() {
        return modelName;
    }
    
    public DeviceTypeName getDeviceType() {
        return deviceType;
    }

    public ColorName getColorName() {
        return colorName;
    }
    
    public ColorRGB getColorRGB() {
        return colorRGB;
    }

    public LocalDate getSinceDate() {
        return sinceDate;
    }

    public LocalDate getTillDate() {
        return tillDate;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public Comparator<Device> getOrder() {
        return order;
    }

    public DeviceFilter withId(Integer id) {
        this.id = id;
        return this;
    }

    public DeviceFilter withPrice(Integer price) {
        this.price = price;
        return this;
    }

    
    public DeviceFilter withModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }
    
    public DeviceFilter withDeviceType(DeviceTypeName deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public DeviceFilter withColorName(ColorName colorName) {
        this.colorName = colorName;
        return this;
    }
    
    public DeviceFilter withColorRGB(ColorRGB colorRGB) {
        this.colorRGB = colorRGB;
        return this;
    }

    public DeviceFilter withSinceDate(LocalDate date) {
        this.sinceDate = date;
        return this;
    }
    
    public DeviceFilter withTillDate(LocalDate date) {
        this.tillDate = date;
        return this;
    }

    public DeviceFilter withManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }
    
    public DeviceFilter withOrder(Comparator<Device> order) {
        this.order = order;
        return this;
    }
    

}
