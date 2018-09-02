package entities;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ryukki on 03.07.2018.
 */
public class TankMeasure extends BaseClass implements Serializable {
    private Integer locationId;//always empty
    private Integer meterId;//always empty
    private Integer fuelHeight;//always zero
    private Double fuelVolume;
    private Integer fuelTemperature;
    private Integer waterHeight;//always empty
    private Integer waterVolume;//always empty

    public Integer getLocationId() {
        return locationId;
    }

    public Integer getMeterId() {
        return meterId;
    }

    public Integer getFuelHeight() {
        return fuelHeight;
    }

    public Double getFuelVolume() {
        return fuelVolume;
    }

    public Integer getFuelTemperature() {
        return fuelTemperature;
    }

    public Integer getWaterHeight() {
        return waterHeight;
    }

    public Integer getWaterVolume() {
        return waterVolume;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public void setMeterId(Integer meterId) {
        this.meterId = meterId;
    }

    public void setFuelHeight(Integer fuelHeight) {
        this.fuelHeight = fuelHeight;
    }

    public void setFuelVolume(Double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public void setFuelTemperature(Integer fuelTemperature) {
        this.fuelTemperature = fuelTemperature;
    }

    public void setWaterHeight(Integer waterHeight) {
        this.waterHeight = waterHeight;
    }

    public void setWaterVolume(Integer waterVolume) {
        this.waterVolume = waterVolume;
    }

    public TankMeasure() {
        locationId = 0;
        meterId = 0;
        fuelHeight = 0;
        waterHeight = 0;
        waterVolume = 0;
    }
}
