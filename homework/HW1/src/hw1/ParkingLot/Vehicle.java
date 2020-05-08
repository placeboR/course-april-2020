package hw1.ParkingLot;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Vehicle {
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;

    public int getSpotsNeeded(){
        return spotsNeeded;
    }
    public VehicleSize getSize(){
        return size;
    }
    public void parkIn(ParkingSpot s){
        parkingSpots.add(s);
    }
    public void parkOut(){
        for (ParkingSpot s : parkingSpots){
            s.removeVehicle();
        }
        parkingSpots.clear();
    }
    public abstract boolean canFitInSpot(ParkingSpot spot);
}

