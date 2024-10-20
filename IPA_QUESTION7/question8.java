import java.util.Arrays;
import java.util.Scanner;

class Student {
    private int rollNo;
    private String name;
    private String subject;
    private char grade;
    private String date;

    Student(int rollNo, String name, String subject, char grade, String date) {
        this.rollNo = rollNo;
        this.name = name;
        this.subject = subject;
        this.grade = grade;
        this.date = date;
    }

    public int getrollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public char getGrade() {
        return grade;
    }

    public String getDate() {
        return date;
    }
}

public class question8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        Student[] st=new Student[n];
        for(int i=0;i<n;i++){
            int roll=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            String sub=sc.nextLine();
            char grad=sc.next().charAt(0);sc.nextLine();
            String date=sc.nextLine();

            st[i]=new Student(roll, name, sub, grad, date);
        }

        char grd=sc.next().charAt(0);sc.nextLine();
        int mnt=sc.nextInt();

        Student[] res=findStudentByGradeAndMonth(st, grd, mnt);
        if(res!=null){
            if(res.length>1){
                for(int i=0;i<res.length;i++){
                    for(int j=i+1;j<res.length;j++){
                        if(res[i].getrollNo()>res[j].getrollNo()){
                            Student temp=res[i];
                            res[i]=res[j];
                            res[j]=temp;
                        }
                    }
                }
                for(int i=0;i<res.length;i++){
                    System.out.println(res[i].getName());
                    System.out.println(res[i].getSubject());
                }
                System.out.println(res.length);
            }else{
                for(int i=0;i<res.length;i++){
                    System.out.println(res[i].getName());
                    System.out.println(res[i].getSubject());
                }
            }  
        }else{
            System.out.println("No student found");
        }

    }

    public static Student[] findStudentByGradeAndMonth(Student[] st,char grd,int month) {
        Student[] st1=new Student[0];
        for(int i=0;i<st.length;i++){
            String[] mth=st[i].getDate().split("/");
            int x=Integer.parseInt(mth[1]);
            if(st[i].getGrade()==grd  && x==month){
                st1=Arrays.copyOf(st1, st1.length+1);
                st1[st1.length-1]=st[i];
            }
        }
        if(st1.length>0){
            return st1;
        }else{
            return null;
        }
    }
}

