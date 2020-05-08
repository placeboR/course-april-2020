package hw1.ParkingLot;

public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int available = 0;
    private int rowSize = 10;
    Level(int floor, int numOfSpots){
        this.floor = floor;
        available = numOfSpots;
        spots = new ParkingSpot[available];
        int LargeSpots = available / 4;
        int MotoSpots = available / 4;
        int CompactSpots = available - LargeSpots - MotoSpots;
        for (int i=0; i<available; ++i){
            VehicleSize sz;
            if(i < MotoSpots){
                sz = VehicleSize.Motorcycle;
            }
            else if(i < MotoSpots + LargeSpots){
                sz = VehicleSize.Large;
            }
            else{
                sz = VehicleSize.Compact;
            }
            int row = i / rowSize;
            spots[i] = new ParkingSpot(this, row, i, sz);
        }
    }
    public int getAvailable(){
        return available;
    }
    public int findAvailableSpots(Vehicle v){
        int spotsNeeded = v.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;
        for(int i=0; i<spots.length; ++i){
            ParkingSpot spot = spots[i];
            if(lastRow != spot.getLane()){
                spotsFound = 0;
                lastRow = spot.getLane();
            }
            if (spot.VehicleFit(v)){
                ++spotsFound;
            }
            else{
                spotsFound = 0;
            }
            if(spotsFound == spotsNeeded){
                switch (v.size){
                    case Large:
                        System.out.println("Parked: Large Car");
                        break;
                    case Compact:
                        System.out.println("Parked: Compact Car");
                        break;
                    case Motorcycle:
                        System.out.println("Parked: Motorcycle");
                }
                System.out.println("Lane Number: " + lastRow);
                return i - (spotsNeeded - 1);
            }
        }
        return -1;
    }
    private boolean parkInSpots(int num, Vehicle v){
        v.parkOut();
        boolean success = true;
        for (int i=num; i<num+v.spotsNeeded; ++i){
            success &= spots[i].parkIn(v);
        }
        available -= v.spotsNeeded;
        return success;
    }
    public boolean parkIn(Vehicle v){
        if(available < v.getSpotsNeeded()){
            return false;
        }
        int spotNumber = findAvailableSpots(v);
        if (spotNumber < 0){
            return false;
        }
        System.out.println("Spot Number: " + spotNumber);
        return parkInSpots(spotNumber, v);
    }
    public void spotFree(){
        ++available;
    }

    public ParkingSpot[] getSpots() {
        return spots;
    }
}











