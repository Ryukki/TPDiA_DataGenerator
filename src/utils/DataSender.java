package utils;
import entities.NozzleMeasure;
import entities.Refuel;
import entities.TankMeasure;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by kacper on 2018-08-13.
 */
public class DataSender {

    private List<TankMeasure> tankMeasuresData;
    private List<NozzleMeasure> nozzleMeasureData;
    private List<Refuel> refuelData;

    private List<TankMeasure> tankMeasuresDataPart;
    private List<NozzleMeasure> nozzleMeasureDataPart;
    private List<Refuel> refuelDataPart;

    private Date currentDate;
    private int port = 6868;
    private static int INTERVAL = 500; //miliseconds
    private String hostname = "localhost";

    public DataSender(){

        TxtFileParser txtFileParser = new TxtFileParser();
        tankMeasuresData = txtFileParser.readTankMeasures("DanePaliwowe//Zestaw1//tankMeasures.log");
        nozzleMeasureData = txtFileParser.readNozzleMeasures("DanePaliwowe//Zestaw1//nozzleMeasures.log");
        refuelData = txtFileParser.readRefuel("DanePaliwowe//Zestaw1//refuel.log");

        tankMeasuresDataPart = new ArrayList<>();
        nozzleMeasureDataPart = new ArrayList<>();
        refuelDataPart = new ArrayList<>();
    }

    public void simulate(){
        new Thread(new Runnable() {
            public void run() {
                setDate();

                while(!tankMeasuresData.isEmpty() || !nozzleMeasureData.isEmpty() || !refuelData.isEmpty()){
                    stepOverDate();
                    extractData();
                    sendData();
                    clearLists();
                    try {
                        Thread.sleep(INTERVAL);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void clearLists() {
        nozzleMeasureDataPart.clear();
        tankMeasuresDataPart.clear();
        refuelDataPart.clear();
    }

    private void sendData() {

        try (Socket socket = new Socket(hostname, port)) {
            String dataHeader;
            ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
            if(!nozzleMeasureDataPart.isEmpty()){
                System.out.println("sending NozzleMeasure data from: "+ nozzleMeasureDataPart.get(0).getMeasureDate());
                dataHeader = "nozzleMeasure";
                toServer.writeObject(dataHeader);
                toServer.writeObject(nozzleMeasureDataPart);
            }

            if(!tankMeasuresDataPart.isEmpty()){
                System.out.println("sending TankMeasure data from: "+ tankMeasuresDataPart.get(0).getMeasureDate());
                dataHeader = "tankMeasure";
                toServer.writeObject(dataHeader);
                toServer.writeObject(tankMeasuresDataPart);
            }

            if(!refuelDataPart.isEmpty()){
                System.out.println("sending Refuel data from: "+ refuelDataPart.get(0).getMeasureDate());
                dataHeader = "refuel";
                toServer.writeObject(dataHeader);
                toServer.writeObject(refuelDataPart);
            }

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }

    private void setDate() {
        currentDate = nozzleMeasureData.get(0).getMeasureDate();
    }

    private void extractData() {

        while(!nozzleMeasureData.isEmpty() && nozzleMeasureData.get(0).getMeasureDate().before(currentDate)){
            nozzleMeasureDataPart.add(nozzleMeasureData.get(0));
            nozzleMeasureData.remove(0);
        }

        while(!tankMeasuresData.isEmpty() && tankMeasuresData.get(0).getMeasureDate().before(currentDate)){
            tankMeasuresDataPart.add(tankMeasuresData.get(0));
            tankMeasuresData.remove(0);
        }

        while(!refuelData.isEmpty() && refuelData.get(0).getMeasureDate().before(currentDate)){
            refuelDataPart.add(refuelData.get(0));
            refuelData.remove(0);
        }
    }

    private void stepOverDate() {
        currentDate = addMinutes(currentDate, 25);
    }

    private static Date addMinutes(Date date, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

}
