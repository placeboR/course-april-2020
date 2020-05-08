package hw1.ParkingLot;

public class LargeCar extends Vehicle {
    LargeCar(int spotsNeeded, String licensePlate){
        this.spotsNeeded = spotsNeeded;
        size = VehicleSize.Large;
        this.licensePlate = licensePlate;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSpotSize() == VehicleSize.Large;
    }
}
