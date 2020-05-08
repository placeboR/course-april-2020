package hw1.ParkingLot;

public class mainFunc {
    public static void main(String[] args){
        ParkingLot P = new ParkingLot(10);
        CompactCar cmpCar = new CompactCar(1, "11111");
        LargeCar lgCar = new LargeCar(1, "22222");
        Motorcycle moto = new Motorcycle(1, "23333");
        P.parkIn(cmpCar);
        P.parkIn(lgCar);
        P.parkIn(moto);
        P.parkOut(cmpCar, 0);
    }
}
