package hw1.ParkingLot;

import java.util.ArrayList;
import java.util.Map;

public class ParkingLot {
    private Level[] levels;
    private int NumofLevel = 2;
    private int SpotsPerLevel;

    public ParkingLot(int numofSpots) {
        SpotsPerLevel = numofSpots;
        levels = new Level[NumofLevel];
        for (int i=0; i<NumofLevel; ++i){
            levels[i] = new Level(i, SpotsPerLevel);
            System.out.println("Initialized level " + i);
        }
    }

    public ParkingLot(int numofLevel, int spotsPerLevel) {
        NumofLevel = numofLevel;
        SpotsPerLevel = spotsPerLevel;
        levels = new Level[NumofLevel];
        for (int i=0; i<NumofLevel; ++i){
            levels[i] = new Level(i, SpotsPerLevel);
            System.out.println("Initialized level " + i);
        }
    }
    public boolean parkIn(Vehicle v){
        for (int i=0; i<levels.length; ++i){
            if (levels[i].parkIn(v)){
                System.out.println("Parked In: Level " + i + ", License: " + v.licensePlate);
                return true;
            }
        }
        return false;
    }
    public boolean parkOut(Vehicle v, int level){
        if (v == null) return false;
        ParkingSpot[] spots = levels[level].getSpots();
        for (int i=0; i<spots.length; ++i){
            if (v.licensePlate.equals(spots[i].getVehicleInfo())){
                spots[i].removeVehicle();
                System.out.println("Parked Out: Level " + level + ", License: " + v.licensePlate);
                return true;
            }
        }
        return false;
    }
}
