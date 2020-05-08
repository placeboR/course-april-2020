package hw1.ParkingLot;

public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int lane;
    private int spotNumber;
    private Level level;
    ParkingSpot(Level level, int row, int spotNumber, VehicleSize sz){
        this.level = level;
        this.lane = row;
        this.spotNumber = spotNumber;
        this.spotSize = sz;
    }
    public boolean isAvailable(){
        return vehicle == null;
    }
    public boolean VehicleFit(Vehicle vehicle){
        return isAvailable()&&vehicle.canFitInSpot(this);
    }
    public boolean parkIn(Vehicle v){
        if(!VehicleFit(v)){
            return false;
        }
        vehicle = v;
        vehicle.parkIn(this);
        return true;
    }
    public int getLane(){
        return lane;
    }
    public int getSpotNumber(){
        return spotNumber;
    }
    public VehicleSize getSpotSize(){
        return spotSize;
    }
    public void removeVehicle(){
        level.spotFree();
        vehicle = null;
    }

    public String getVehicleInfo() {
        if (vehicle == null)
            return null;
        return vehicle.licensePlate;
    }
}
