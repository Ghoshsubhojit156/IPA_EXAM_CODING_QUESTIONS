import java.util.Arrays;
import java.util.Scanner;

class HeadSet{
    String headsetName;
    String brand;
    int price;
    boolean available;
    HeadSet(String headsetName,String brand,int price,boolean available){
        this.headsetName=headsetName;
        this.brand=brand;
        this.price=price;
        this.available=available;
    }
    //Getters
    public String getHeadSetName(){ 
        return headsetName;
    }
    public String getBrand(){
        return brand;
    }
    public int getPrice(){
        return price;
    }
    public boolean getAvailable(){
        return available;
    }

    // Setters
    public void setHeadSetNAme(String hdn){
        this.headsetName=hdn;
    }
}


public class IPA5{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        HeadSet[] hs=new HeadSet[n];
        for (int i = 0; i < n; i++) {
            String name=sc.nextLine();
            String brand=sc.nextLine();
            int price=sc.nextInt();sc.nextLine();
            boolean avail=sc.nextBoolean();sc.nextLine();

            hs[i]=new HeadSet(name, brand, price, avail);
        }
        String brand=sc.nextLine();
        int tot=findTotalPriceForGivenBrand(hs, brand);
        if(tot>0){
            System.out.println(tot);
        }else{
            System.out.println("No Headsets available with the given brand");
        }
        HeadSet[] res=findAvailableHeadsetWithSecondMinPrice(hs);
        // System.out.println(res.length);
        if(res!=null){
            System.out.println(res[1].getHeadSetName());
            System.out.println(res[1].getPrice());
        }else{
            System.out.println("No Headsets available");
        }
    }
    public static int findTotalPriceForGivenBrand(HeadSet[] hs,String brand) {
        int total=0;
        for (int i = 0; i < hs.length; i++) {
            if(hs[i].getBrand().equals(brand)){
                total=total+hs[i].getPrice();
            }
        }
        if(total>0){
            return total;
        }else{
            return 0;
        }
    }
    public static HeadSet[] findAvailableHeadsetWithSecondMinPrice(HeadSet[] hs) {
        HeadSet[] hs1=new HeadSet[0];
        for (int i = 0; i < hs.length; i++) {
            if(hs[i].getAvailable()==true){
                hs1=Arrays.copyOf(hs1, hs1.length+1);
                hs1[hs1.length-1]=hs[i];
            }
        }
        for (int i = 0; i < hs1.length; i++) {
            for (int j = i+1; j < hs1.length; j++) {
                if(hs1[i].getPrice()>hs1[j].getPrice()){
                    HeadSet temp=hs1[i];
                    hs1[i]=hs1[j];
                    hs1[j]=temp;
                }
            }
        }
        if(hs1.length>0){
            return hs1;
        }else{
            return null;
        }

    }
}
