package entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ryukki on 03.07.2018.
 */
public class Refuel extends BaseClass implements Serializable{
    private Double fuelVolume;

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
