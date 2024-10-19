import java.util.*;

class NavalVessel {
    int vesselld;
    String vesselName;
    int noOfVoyagesPlanned;
    int noOfVoyagesCompleted;
    String purpose;

    NavalVessel(int vesselld, String vesselName, int noOfVoyagesPlanned, int noOfVoyagesCompleted, String purpose) {
        this.vesselld = vesselld;
        this.vesselName = vesselName;
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
        this.noOfVoyagesCompleted = noOfVoyagesCompleted;
        this.purpose = purpose;
    }

    public int getVesselId() {
        return vesselld;
    }

    public String getvesselName() {
        return vesselName;
    }

    public int getnoOfVoyagesPlanned() {
        return noOfVoyagesPlanned;
    }

    public int getnoOfVoyagesCompleted() {
        return noOfVoyagesCompleted;
    }

    public String getPurpose() {
        return purpose;
    }
}

public class question6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        NavalVessel[] nv=new NavalVessel[n];
        for(int i=0;i<nv.length;i++){
            int id=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            int plan=sc.nextInt();sc.nextLine();
            int complete=sc.nextInt();sc.nextLine();
            String purpose=sc.nextLine();

            nv[i]=new NavalVessel(id, name, plan, complete, purpose);
        }
        int perc=sc.nextInt();sc.nextLine();
        String purp1=sc.nextLine();
        int avg=findAvgVoyagesByPct(nv, perc);
        if(avg>0){
            System.out.println(avg);
        }else{
            System.out.println("Avg Not Found");
        }
        NavalVessel[] res=findVesselByGrade(nv, purp1);
        if(res!=null){
            for(int i=0;i<res.length;i++){
                int perc1=(res[i].getnoOfVoyagesCompleted()*100)/res[i].getnoOfVoyagesPlanned();
                if(perc1==100){
                    System.out.println(res[i].getvesselName()+"%Star");
                }else if(perc1>=80 && perc1<99){
                    System.out.println(res[i].getvesselName()+"%Leader");
                }else if(perc1>=55 && perc1<79){
                    System.out.println(res[i].getvesselName()+"%Inspirer");
                }else{
                    System.out.println(res[i].getvesselName()+"%Striver");
                }
            }
        }else{
            System.out.println("No Naval");
        }

    }
    public static int findAvgVoyagesByPct(NavalVessel[] nv,int percentage){
        int sum=0;
        int tot=0;

        
        for(int i=0;i<nv.length;i++){
            int perc=(nv[i].getnoOfVoyagesCompleted() * 100)/nv[i].getnoOfVoyagesPlanned();
            if(perc>=percentage){
                tot+=1;
                sum=sum+nv[i].getnoOfVoyagesCompleted();
            } 
        }
        if(sum>0){
            return sum/tot;
        }else{
            return 0;
        }
        
    }
    public static NavalVessel[] findVesselByGrade(NavalVessel[] nv,String purp) {
        NavalVessel[] nv1=new NavalVessel[0];
        for(int i=0;i<nv.length;i++){
            if(nv[i].getPurpose().equals(purp)){
                nv1=Arrays.copyOf(nv1, nv1.length+1);
                nv1[nv1.length-1]=nv[i];
            }
        }
        if(nv1.length>0)
        {
            return nv1;
        }else{
            return null;
        }
        
    }
}
