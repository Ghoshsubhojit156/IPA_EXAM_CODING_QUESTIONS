import java.util.Arrays;
import java.util.Scanner;

class AutonomousCar {
    int carId;
    String brand;
    int noOfTestsConducted;
    int noOfTestsPassed;
    String environment;

    AutonomousCar(int carId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment) {
        this.carId = carId;
        this.brand = brand;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment = environment;
    }

    // Getters
    public int getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public int getnoOfTestsConducted() {
        return noOfTestsConducted;
    }

    public int getnoOfTestsPassed() {
        return noOfTestsPassed;
    }

    public String getEnvironment() {
        return environment;
    }

    // Setters
    public void setcarId(int id) {
        this.carId = id;
    }

}

public class solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        AutonomousCar[] ac = new AutonomousCar[n];
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String brand = sc.nextLine();
            int conduct = sc.nextInt();
            sc.nextLine();
            int passed = sc.nextInt();
            sc.nextLine();
            String env = sc.nextLine();

            ac[i] = new AutonomousCar(id, brand, conduct, passed, env);
        }

        String env=sc.nextLine();
        String brand=sc.nextLine();
        int res=findTestPassedByEnv(ac, env);
        System.out.println(res);
        AutonomousCar[] res2=updateCarGrade(brand, ac);
        if(res2!=null){
            for(int i=0;i<res2.length;i++){
                int rating=(res2[i].getnoOfTestsPassed()* 100)/res2[i].getnoOfTestsConducted();
                if(rating>=80){
                    System.out.println(res2[i].getBrand()+" :: "+ "A1");
                }else{
                    System.out.println(res2[i].getBrand()+" :: "+ "B2");
                }
            }
        }else{
            System.out.println("No Car is available with the specified brand");
        }

    }
    public static int findTestPassedByEnv(AutonomousCar[] ac, String env) {
        int sum = 0;
        for (int i = 0; i < ac.length; i++) {
            if (ac[i].getEnvironment().equals(env)) {
                sum = sum + ac[i].getnoOfTestsPassed();
            }
        }
        if (sum > 0) {
            return sum;
        } else {
            return 0;
        }
    }

    public static AutonomousCar[] updateCarGrade(String bran, AutonomousCar[] ac) {
        AutonomousCar[] grade = new AutonomousCar[0];
        for (int i = 0; i < ac.length; i++) {
            if (ac[i].getBrand().equals(bran)) {
                grade = Arrays.copyOf(grade, grade.length + 1);
                grade[grade.length - 1] = ac[i];
            }
        }
        if (grade.length > 0) {
            return grade;
        } else {
            return null;
        }
    }
}
