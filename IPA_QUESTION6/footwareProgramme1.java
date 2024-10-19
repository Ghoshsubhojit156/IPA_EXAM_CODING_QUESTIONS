import java.util.*;
class Footwear {
    private int footwearId;
    private String footwearName;
    private String footwearType;
    private int price;

    Footwear(int footwearId, String footwearName, String footwearType, int price) {
        this.footwearId = footwearId;
        this.footwearName = footwearName;
        this.footwearType = footwearType;
        this.price = price;
    }

    // Getters
    public int getfootId() {
        return footwearId;
    }

    public String getName() {
        return footwearName;
    }

    public String getType() {
        return footwearType;
    }

    public int getPrice() {
        return price;
    }

}

public class footwareProgramme1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Footwear[] fw = new Footwear[n];
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String type = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();

            fw[i] = new Footwear(id, name, type, price);
        }
        String type = sc.nextLine();
        String name = sc.nextLine();
        int res = getCountByType(fw, type);
        if (res != 0) {
            System.out.println(res);
        } else {
            System.out.println("Footwear not available");
        }

        Footwear[] res1 = getSecondHighestPriceByBrand(fw, name);
        if (res1 != null) {
            for(int i=0;i<res1.length;i++){
                for(int j=i+1;j<res1.length;j++){
                    if(res1[i].getPrice()>res1[j].getPrice()){
                        Footwear temp=res1[i];
                        res1[i]=res1[j];
                        res1[j]=temp;
                    }
                }
            }
            System.out.println(res1[res1.length-1].getfootId());
            System.out.println(res1[res1.length-1].getName());
            System.out.println(res1[res1.length-1].getPrice());
        } else {
            System.out.println("Brand not available");
        }

    }
public static int getCountByType(Footwear[] fw, String type) {
        int count = 0;
        for (int i = 0; i < fw.length; i++) {
            if (fw[i].getType().equalsIgnoreCase(type)) {
                count++;
            }
        }
        if (count > 0) {
            return count;
        } else {
            return 0;
        }
    }
    public static Footwear[] getSecondHighestPriceByBrand(Footwear[] fw, String Name) {
        Footwear[] fw1=new Footwear[0];
        for (int i = 0; i < fw.length; i++) {
            if (fw[i].getName().equals(Name)) {
                fw1=Arrays.copyOf(fw1, fw1.length+1);
                fw1[fw1.length-1]=fw[i];
            }
        }
        if(fw1.length>0){
            return fw1;
        }else{

            return null;
        }


    }
}


