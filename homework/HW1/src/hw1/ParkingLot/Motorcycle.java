package hw1.ParkingLot;

public class Motorcycle extends Vehicle {
    Motorcycle(int SpotsNeeded, String licensePlate){
        this.licensePlate = licensePlate;
        this.size = VehicleSize.Motorcycle;
        this.spotsNeeded = SpotsNeeded;
    }
    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSpotSize() == VehicleSize.Motorcycle;
    }
}
