import java.util.*;
class Player3{
    private int id;
    private String name;
    private String Country;
    private int matchesPlayed;
    private int runsScored;

    Player3(int id,String name,String Country,int matchesPlayed,int runsScored){
        this.id=id;
        this.name=name;
        this.Country=Country;
        this.matchesPlayed=matchesPlayed;
        this.Country=Country;
        this.runsScored=runsScored;
    }

    //Getters
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getCountry(){
        return Country;
    }
    public int getMatchesPlayed(){
        return matchesPlayed;
    }
    public int getRunsScored(){
        return runsScored;
    }
}
public class IPA3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        Player3[] pl=new Player3[n];
        for(int i=0;i<n;i++){
            int id=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            String country=sc.nextLine();
            int matches=sc.nextInt();sc.nextLine();
            int runs=sc.nextInt();sc.nextLine();


            pl[i]=new Player3(id, name, country, matches, runs);
        }
        String country=sc.nextLine();
        int runsScored=sc.nextInt();
        Player3[] res=findPlayerName(pl, country, runsScored);
        if(res!=null){
          // to sort String elements of getName()
            for(int i=0;i<res.length;i++){
                for(int j=i+1;j<res.length;j++){
                    if(res[i].getName().compareTo(res[j].getName())>0){
                        Player3 temp=res[i];
                        res[i]=res[j];
                        res[j]=temp;
                    }
                }
            }
            for(int i=0;i<res.length;i++){
                System.out.println(res[i].getId()+" : "+res[i].getName());
            }
        }else{
            System.out.println("No player found");
        }
    }
    public static Player3[] findPlayerName(Player3[] pl,String country,int run) {
        Player3[] pl1=new Player3[0];
        for(int i=0;i<pl.length;i++){
            if(pl[i].getCountry().equals(country) && pl[i].getRunsScored()>80){
                pl1=Arrays.copyOf(pl1,pl1.length+1);
                pl1[pl1.length-1]=pl[i];
            }
        }
        if(pl1.length>0){
            return pl1;
        }else{
            return null;
        }
    }
}
