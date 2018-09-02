package entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ryukki on 02.09.2018.
 */
public class BaseClass implements Serializable {
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
}
