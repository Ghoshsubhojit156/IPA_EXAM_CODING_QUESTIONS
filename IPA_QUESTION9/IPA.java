import java.util.Arrays;
import java.util.Scanner;

class Institution{
    int institutionId;
    String institutionName;
    int noOfStudentsPlaced;
    int noOfStudentsCleared;
    String location;
    String grade;

    Institution(int institutionId,String institutionName,int noOfStudentsPlaced,int noOfStudentsCleared,String location){
        this.institutionId=institutionId;
        this.institutionName=institutionName;
        this.noOfStudentsPlaced=noOfStudentsPlaced;
        this.noOfStudentsCleared=noOfStudentsCleared;
        this.location=location;
    }
    //Getters
    public int getinstitutionId(){
        return institutionId;
    }
    public String getinstitutionName(){
        return institutionName;
    }
    public int getnoOfStudentsPlaced(){
        return noOfStudentsPlaced;
    }
    public int getnoOfStudentsCleared(){
        return noOfStudentsCleared;
    }
    public String getLocation(){
        return location;
    }
    public String getGrade(){
        return grade;
    }
    //Setters
    public void setInstitutionId(int id){
        this.institutionId=id;
    }
    public void setInstitutionName(String name){
        this.institutionName=name;
    }
    public void setnoOfStudentsPlaced(int place){
        this.noOfStudentsPlaced=place;
    }
    public void setnoOfStudentsCleared(int clear){
        this.noOfStudentsCleared=clear;
    }
    public void setLocation(String loc){
        this.location=loc;
    }
    public void setGrade(String grd){
        this.grade=grd;
    }
    

}

public class IPA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        Institution[] inst=new Institution[n];
        for(int i=0;i<n;i++){
            int id=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            int place=sc.nextInt();sc.nextLine();
            int clear=sc.nextInt();sc.nextLine();
            String loc=sc.nextLine();

            inst[i]=new Institution(id, name, place, clear, loc);
        }
        String loc=sc.nextLine();
        String name=sc.nextLine();
        int res=FindNumClearancedByLoc(inst, loc);
        if(res>0){
            System.out.println(res);
        }else{
            System.out.println();
        }
        Institution[] res1=UpdateInstitutionGrade(inst, name);
        if(res1!=null){
            for(int i=0;i<res1.length;i++){
                int Rating=(res1[i].getnoOfStudentsPlaced()* 100)/res1[i].getnoOfStudentsCleared();
                if(Rating>=80){
                    res1[i].setGrade("A");
                }else{
                    res1[i].setGrade("B");
                }
            }
            for (int i = 0; i < res1.length; i++) {
                System.out.println(res1[i].getinstitutionName()+"::"+res1[i].getGrade());    
            }
        }else{
            System.out.println("There are no cleared students in this particular location");
        }
    }
    public static int FindNumClearancedByLoc(Institution[] inst,String loc){
        int sum=0;
        for(int i=0;i<inst.length;i++){
            if(inst[i].getLocation().equals(loc)){
                sum=sum+inst[i].getnoOfStudentsCleared();
            }
        }
        if(sum>0){
            return sum;
        }else{
            return 0;
        }
    }
    public static Institution[] UpdateInstitutionGrade(Institution[] inst,String instName){
        Institution[] inst1=new Institution[0];
        for(int i=0;i<inst.length;i++){
            if(inst[i].getinstitutionName().equals(instName)){
                inst1=Arrays.copyOf(inst1, inst1.length+1);
                inst1[inst1.length-1]=inst[i];
            }
        }
        if(inst1.length>0){
            return inst1;
        }else{
            return null;
        }
    }
}
