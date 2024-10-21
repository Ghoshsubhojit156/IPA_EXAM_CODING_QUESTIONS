import java.util.Arrays;
import java.util.Scanner;

class Flowers {
    private int flowerId;
    private String flowerName;
    private int price;
    private int rating;
    private String type;

    Flowers(int flowerId, String flowerName, int price, int rating, String type) {
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.price = price;
        this.rating = rating;
        this.type = type;
    }

    // Getters
    public int getFlowerId() {
        return flowerId;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public int getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public String getType() {
        return type;
    }
}

public class IPA2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Flowers[] fw = new Flowers[n];
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();
            int rating = sc.nextInt();
            sc.nextLine();
            String type = sc.nextLine();

            fw[i] = new Flowers(id, name, price, rating, type);
        }
        String type = sc.nextLine();
        Flowers[] res1 = findMinPriceByType(fw, type); // 12 13 14
        if (res1 != null) {
            System.out.println("Output: "+res1[0].getFlowerId());
        } else {
            System.out.println("There is no flower with given type");
        }
    }

    public static Flowers[] findMinPriceByType(Flowers[] fw, String Type) {
        Flowers[] fw1 = new Flowers[0];
        for (int i = 0; i < fw.length; i++) {
            if (fw[i].getType().equals(Type)) {
                if (fw[i].getRating() > 3) {
                    fw1 = Arrays.copyOf(fw1, fw1.length + 1);
                    fw1[fw1.length - 1] = fw[i];
                }
            }
        }
        for (int i = 0; i < fw1.length; i++) {
            for (int j = i + 1; j < fw1.length; j++) {
                if (fw1[i].getPrice() > fw1[j].getPrice()) {
                    Flowers temp = fw1[i];
                    fw1[i] = fw1[j];
                    fw1[j] = temp;
                }
            }
        }
        if (fw1.length > 0) {
            return fw1;
        } else {
            return null;
        }
    }
}
