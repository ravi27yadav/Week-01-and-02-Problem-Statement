import java.util.*;

public class ParkingSystem {

    String[] spots=new String[500];

    int hash(String plate){
        return Math.abs(plate.hashCode())%500;
    }

    void park(String plate){

        int index=hash(plate);

        while(spots[index]!=null){
            index=(index+1)%500;
        }

        spots[index]=plate;

        System.out.println("Vehicle parked at spot "+index);
    }

    public static void main(String[] args){

        ParkingSystem p=new ParkingSystem();

        p.park("ABC123");
        p.park("XYZ999");
    }
}