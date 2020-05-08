package hw1.ParkingLot;

public class CompactCar extends Vehicle {
    CompactCar(int NeededSpots, String licensePlate){
        this.spotsNeeded = NeededSpots;
        this.size = VehicleSize.Compact;
        this.licensePlate = licensePlate;
    }
    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSpotSize() == VehicleSize.Compact;
    }
}
