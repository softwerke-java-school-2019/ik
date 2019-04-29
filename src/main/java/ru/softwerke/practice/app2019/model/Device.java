package ru.softwerke.practice.app2019.model;
import ru.softwerke.practice.app2019.model.Model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;



import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
//import java.util.UUID;

public class Device implements Model{
    public static final String ID_FIELD = "id";
    public static final String PRICE_FIELD = "price";
	public static final String MODEL_NAME_FIELD = "modelName";
    public static final String DEVICE_TYPE_FIELD = "deviceType";
    public static final String COLOR_NAME_FIELD = "colorName";
    public static final String COLOR_RGB_FIELD = "colorRGB";
    public static final String MANUFACTURE_DATE_FIELD = "manufactureDate";
    public static final String MANUFACTURER_FIELD = "manufacturer";
    public static final String DATE_FORMAT = "dd.MM.yyyy";

    @JsonProperty(ID_FIELD)
    private Integer id;

    @JsonProperty(PRICE_FIELD)
    private final Integer price;

    @JsonProperty(MODEL_NAME_FIELD)
    private final String modelName;
    
    @JsonProperty(DEVICE_TYPE_FIELD)
    private final DeviceTypeName deviceType;

    @JsonProperty(COLOR_NAME_FIELD)
    private final ColorName colorName;
    
    @JsonProperty(COLOR_RGB_FIELD)
    private final ColorRGB colorRGB;
    

    @JsonProperty(MANUFACTURE_DATE_FIELD)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    //@XmlJavaTypeAdapter(DateManager.class)
    private final LocalDate manufactureDate;

    @JsonProperty(MANUFACTURER_FIELD)
    private final String manufacturer;

    @JsonCreator
    public Device(
            @NotNull @JsonProperty(PRICE_FIELD) Integer price,
            @NotNull @JsonProperty(MODEL_NAME_FIELD) String modelName,
            @NotNull @JsonProperty(DEVICE_TYPE_FIELD) DeviceTypeName deviceType,
            @JsonProperty(COLOR_NAME_FIELD) ColorName colorName,
            @JsonProperty(COLOR_RGB_FIELD) ColorRGB colorRGB,
            @NotNull @JsonProperty(MANUFACTURE_DATE_FIELD) LocalDate manufactureDate,
            @NotNull @JsonProperty(MANUFACTURER_FIELD) String manufacturer) {
        this.price = price;
        this.modelName = modelName;
        this.deviceType = deviceType;
        this.colorName = colorName==null?new ColorName(colorRGB.intValue()):colorName;
        this.colorRGB = colorRGB==null?new ColorRGB(colorName.toString()):colorRGB;
        this.manufactureDate = manufactureDate;
        this.manufacturer = manufacturer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

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

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device)) return false;
        Device device = (Device) o;
        return id == device.id &&
                price.equals(device.price) &&
                modelName.equals(device.modelName) &&
                colorName.equals(device.colorName) &&
                manufactureDate.equals(device.manufactureDate) &&
                manufacturer.equals(device.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, modelName,deviceType,colorRGB, colorName, manufactureDate, manufacturer);
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", price=" + price +
                ", deviceType=" + deviceType +
                ", modelName='" + modelName + '\'' +
                ", colorName=" + colorName +
                ", colorRGB=" + colorRGB +
                ", manufactureDate=" + manufactureDate +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

}
