// Create a class AutonomousCar with the below attributes:

// carld – int
// brand – String 
// noOfTestsConducted – int
// noOfTestsPassed- int
// environment – String

// Write getters, setters for the above attributes . Create constructor which takes parameter in the above sequence 
// except grade.

// Create class Solution with main method. Implement two static methods – findTestPassedByEnv and updateCarGrade in 
// Solution class.

// findTestPassedByEnv method:

// This method will take two input parameters -array of AutonomousCar objects and string parameter environment. The method 
// will return the sum of the noOfTestsPassed attribute from autonomousCar objects for the environment passed as parameter. 
// If no autonomousCar with the given environment is present in the array of AutonomousCar objects, then the method should 
// return 0.

// updateCarGrade method:

// This method will take a String parameter brand, along with the array of AutonomousCar objects. The method will return 
// the autonomousCar object, if the input String parameter matches with the brand attribute of the autonomousCar object. 
// Before returning the object, the grade should be derived based on the rating calculation mentioned below. This grade 
// value should be assigned to the object. If any of the above conditions are not met, then the method should return null. 
// The grade attribute should be calculated as follows: rating .(noOfTestsPassed * 100)/noOfTestsConducted 
// If the rating > = 80 then grade should be ‘A1’, otherwise the grade should be ‘B2’.

// The above mentioned static methods should be called from the main method. For findTestPassedByEnv method – The main 
// method should print the totalTestPassed as it is, if the returned value is greater than 0, or it should print “There 
// are no tests passed in this particular environment”.

// For updateCarGrade method – The main method should print the brand and grade of the returned autonomousCar object. 
// The brand and grade should be concatinated with :: while printing. eg:- Tesla::A1, where Tesla is the brand and Al 
// is the grade.

// If the returned value is null then it should print “No Car is available with the specified brand”. Before calling these 
// static methods in main, use Scanner object to read the values of four autonomousCar objects referring attributes in the 
// above mentioned attribute sequence (except grade attribute). Next, read the value for environment and brand.

// Input
// ----------------
/*
100
Tesla
1000
500
Hills
200
Ford
2000
1500
Desert
300
Royce
3000
1700
Hills
400
Mercedez
1000
400
Desert
Desert
Mercedez
*/
// Output
// -----------
// 1900
// Mercedez::B2

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
