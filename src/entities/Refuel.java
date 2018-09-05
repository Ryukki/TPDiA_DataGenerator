package entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ryukki on 03.07.2018.
 */
public class Refuel implements Serializable{
    private Double fuelVolume;
    private Date measureDate;
    private Integer tankId;

    public void setMeasureDate(Date measureDate) {
        this.measureDate = measureDate;
    }

    public void setTankId(Integer tankId) {
        this.tankId = tankId;
    }

    public Date getMeasureDate() {

        return measureDate;
    }

    public Integer getTankId() {
        return tankId;
    }

    public Double getFuelVolume() {
        return fuelVolume;
    }

    public Double getTankingSpeed() {
        return tankingSpeed;
    }

    private Double tankingSpeed;

    public void setFuelVolume(Double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public void setTankingSpeed(Double tankingSpeed) {
        this.tankingSpeed = tankingSpeed;
    }
}
