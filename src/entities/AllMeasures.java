package entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ryukki on 05.09.2018.
 */
public class AllMeasures implements Serializable {
    private List<NozzleMeasure> nozzleMeasures;
    private List<TankMeasure> tankMeasures;
    private List<Refuel> refuels;

    public List<NozzleMeasure> getNozzleMeasures() {
        return nozzleMeasures;
    }

    public void setNozzleMeasures(List<NozzleMeasure> nozzleMeasures) {
        this.nozzleMeasures = nozzleMeasures;
    }

    public List<TankMeasure> getTankMeasures() {
        return tankMeasures;
    }

    public void setTankMeasures(List<TankMeasure> tankMeasures) {
        this.tankMeasures = tankMeasures;
    }

    public List<Refuel> getRefuels() {
        return refuels;
    }

    public void setRefuels(List<Refuel> refuels) {
        this.refuels = refuels;
    }
}
