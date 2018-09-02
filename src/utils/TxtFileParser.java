package utils;

import entities.NozzleMeasure;
import entities.Refuel;
import entities.TankMeasure;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created by Ryukki on 03.07.2018.
 */
public class TxtFileParser {
    public List<TankMeasure> readTankMeasures(String filePath){
        List<String> stringList = new ArrayList<>();
        List<TankMeasure> returnList= new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            stringList = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String tankMeasureString: stringList) {
            returnList.add(parseTankMeasureString(tankMeasureString));
        }
        return returnList;
    }

    private TankMeasure parseTankMeasureString(String tankMeasureString){
        TankMeasure tankMeasure = new TankMeasure();
        String[] values = tankMeasureString.split(";");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        try {
            tankMeasure.setMeasureDate(format.parse(values[0]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tankMeasure.setTankId(Integer.parseInt(values[3]));
        tankMeasure.setFuelHeight(Integer.parseInt(values[4]));
        tankMeasure.setFuelVolume(Double.parseDouble(values[5].replaceAll(",", ".")));
        tankMeasure.setFuelTemperature(Integer.parseInt(values[6]));

        return tankMeasure;
    }

    public List<NozzleMeasure> readNozzleMeasures(String filePath){
        List<String> stringList = new ArrayList<>();
        List<NozzleMeasure> returnList= new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            stringList = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String nozzleMeasureString: stringList) {
            returnList.add(parseNozzleMeasureString(nozzleMeasureString));
        }
        return returnList;
    }

    private NozzleMeasure parseNozzleMeasureString(String nozzleMeasureString){
        NozzleMeasure nozzleMeasure = new NozzleMeasure();
        String[] values = nozzleMeasureString.split(";");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        try {
            nozzleMeasure.setMeasureDate(format.parse(values[0]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nozzleMeasure.setPistolId(Integer.parseInt(values[2]));
        nozzleMeasure.setTankId(Integer.parseInt(values[3]));
        nozzleMeasure.setLiterCounter(Double.parseDouble(values[4].replaceAll(",", ".")));
        nozzleMeasure.setTotalCounter(Double.parseDouble(values[5].replaceAll(",", ".")));
        nozzleMeasure.setStatus(Boolean.parseBoolean(values[6]));

        return nozzleMeasure;
    }

    public List<Refuel> readRefuel(String filePath){
        List<String> stringList = new ArrayList<>();
        List<Refuel> returnList= new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            stringList = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String refuelString: stringList) {
            returnList.add(parseRefuelString(refuelString));
        }
        return returnList;
    }

    private Refuel parseRefuelString(String refuelString){
        Refuel refuel = new Refuel();
        String[] values = refuelString.split(";");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        try {
            refuel.setMeasureDate(format.parse(values[0]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        refuel.setTankId(Integer.parseInt(values[1]));
        refuel.setFuelVolume(Double.parseDouble(values[2].replaceAll(",", ".")));
        refuel.setTankingSpeed(Double.parseDouble(values[3].replaceAll(",", ".")));

        return refuel;
    }
}
