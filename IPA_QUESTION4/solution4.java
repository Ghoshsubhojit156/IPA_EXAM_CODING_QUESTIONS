import java.util.Arrays;
import java.util.Scanner;

class Medicine {
    String medicineName;
    String Batch;
    String Disease;
    int Price;

    Medicine(String medicineName, String Batch, String Disease, int Price) {
        this.medicineName = medicineName;
        this.Batch = Batch;
        this.Disease = Disease;
        this.Price = Price;
    }

    // Getters
    public String getMedicineName() {
        return medicineName;
    }

    public String getBatch() {
        return Batch;
    }

    public String getDisease() {
        return Disease;
    }

    public int getPrice() {
        return Price;
    }
}

public class solution4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        Medicine[] md=new Medicine[n];
        for(int i=0;i<n;i++){
            String name=sc.nextLine();
            String batch=sc.nextLine();
            String disease=sc.nextLine();
            int price=sc.nextInt();sc.nextLine();

            md[i]=new Medicine(name, batch, disease, price);
        }
        String disease=sc.nextLine();
        Medicine[] res=getPriceByDisease(md, disease);
        if(res!=null){
            System.out.println("/////////////////////////////////////Output////////////////////");
            for(int i=0;i<res.length;i++){
                System.out.println(res[i].getPrice());
            }
        }else{
            System.out.println("Medicine not Found");
        }
    }
    public static Medicine[] getPriceByDisease(Medicine[] md,String Disease) {
        Medicine[] arr=new Medicine[0];
        for(int i=0;i<md.length;i++){
            if(md[i].getDisease().equalsIgnoreCase(Disease)){
                arr=Arrays.copyOf(arr, arr.length+1);
                arr[arr.length-1]=md[i];
            }
        }
        if(arr.length>0){
            return arr;
        }else{
            return null;
        }
    }
}
