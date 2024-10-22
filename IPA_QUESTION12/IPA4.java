import java.util.*;
class Car{
    int carId;
    String carName;
    String fuelType;
    Car(int carId,String carName,String fuelType){
        this.carId=carId;
        this.carName=carName;
        this.fuelType=fuelType;
    }

    //Getters
    public int getCarID(){
        return carId;
    }
    public String getCarName(){
        return carName;
    }
    public String getFuelType(){
        return fuelType;
    }
}

public class IPA4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        Car[] cr=new Car[n];
        for (int i = 0; i < n; i++) {
            int id=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            String type=sc.nextLine();

            cr[i]=new Car(id, name, type);
        }
        int id=sc.nextInt();
        Car[] res=RemoveAndRearrange(cr, id);
        if(res!=null){
            for (int i = 0; i < res.length; i++) {
                System.out.println(res[i].getCarID()+" : "+ res[i].getCarName());
            }
        }else{
            System.out.println("There are no car with given id");
        }
    }

    public static Car[] RemoveAndRearrange(Car[] cr,int id) {
        Car[] cr1=new Car[0];
        for(int i=0;i<cr.length;i++){
            if(cr[i].getCarID()!=id){
                cr1=Arrays.copyOf(cr1,cr1.length+1);
                cr1[cr1.length-1]=cr[i];
            }
        }
        if(cr1.length>0){
            return cr1;
        }else{
            return null;
        }
    }
}
