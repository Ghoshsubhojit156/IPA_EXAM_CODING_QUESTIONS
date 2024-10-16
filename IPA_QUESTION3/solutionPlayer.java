import java.util.*;
import java.lang.*;
class Player {
    int playerId;
    String skill;
    String level;
    int points;

    Player(int playerId, String skill, String level, int points) {
        this.playerId = playerId;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }

    // Getters
    public int getId() {
        return playerId;
    }

    public String getSkill() {
        return skill;
    }

    public String getLevel() {
        return level;
    }

    public int getPoints() {
        return points;
    }
}

public class solutionPlayer {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        Player[] pl=new Player[n];
        for(int i=0;i<n;i++){
            int id=sc.nextInt();sc.nextLine();
            String skill=sc.nextLine();
            String level=sc.nextLine();
            int points=sc.nextInt();sc.nextLine();

            pl[i]=new Player(id, skill, level, points);
        }
        String skil=sc.nextLine();
        String leve=sc.nextLine();
        int res=findPointsForGivenSkill(pl, skil);
        if(res>0){
            System.out.println(res);
        }else{
            System.out.println("The given Skill is not available");
        }
        Player[] res1=getPlayerBasedOnLevel(pl,skil,leve);
        if(res1!=null){
            for(int i=0;i<res1.length;i++){
                System.out.println(res1[i].getId());
            }
        }else{
            System.out.println("No player is available with specified level, skill and eligibility points");
        }
    }

    public static int findPointsForGivenSkill(Player[] pl, String skill) {
        int sum = 0;
        for (int i = 0; i < pl.length; i++) {
            if (pl[i].getSkill().equalsIgnoreCase(skill)) {
                sum = sum + pl[i].getPoints();
            }
        }
        if (sum > 0) {
            return sum;
        } else {
            return 0;
        }
    }
    public static Player[] getPlayerBasedOnLevel(Player[] pl,String skill,String level){
        Player[] current=new Player[0];
        for(int i=0;i<pl.length;i++){
            if(pl[i].getSkill().equals(skill) && pl[i].getLevel().equals(level) && pl[i].getPoints()>=20){
                current=Arrays.copyOf(current, current.length+1);
                current[current.length-1]=pl[i];
            }
        }
        if(current.length>0){
            return current;
        }else{
            return null;
        }
    }
}
