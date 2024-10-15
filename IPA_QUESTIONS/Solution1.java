import java.util.*;

/*
Create class Movie with below attributes: 

movieName - String 
company - String 
genre - String 
budget - int

Create class Solution and implement static method "getMovieByGenre" in the Solution class. This method will 
take array of Movie objects and a searchGenre String as parameters. And will return another array of Movie 
objects where the searchGenre String matches with the original array of Movie object's genre attribute 
(case insensitive search).

Write necessary getters and setters.

Before calling "getMovieByGenre" method in the main method, read values for four Movie objects referring the 
attributes in above sequence along with a String searchGenre. Then call the "getMovieByGenre" method and write
logic in main method to print "High Budget Movie",if the movie budget attribute is greater than 80000000 else 
print "Low Budget Movie".

Input
---------
aaa
Marvel
Action
250000000
bbb
Marvel
Comedy
25000000
ccc
Marvel
Comedy
2000000
ddd
Marvel
Action
300000000
Action

Output
-------------------
High Budget Movie
High Budget Movie
 */
class Movie {
    String movieName;
    String company;
    String genre;
    int budget;

    Movie(String movieName, String company, String genre, int budget) {
        this.movieName = movieName;
        this.company = company;
        this.genre = genre;
        this.budget = budget;
    }

    // Getters
    public String getMovieName() {
        return movieName;
    }

    public String getcompany() {
        return company;
    }

    public String getGenre() {
        return genre;
    }

    public int getbudget() {
        return budget;
    }

    // Setters
    public void setMovieName(String name) {
        this.movieName = name;
    }

    public void setCompanyNAme(String compName) {
        this.company = compName;
    }

    public void setGenre(String gen) {
        this.genre = gen;
    }

    public void setBudget(int bud) {
        this.budget = bud;
    }

}

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Movie[] m = new Movie[n];
        // movieName - String
        // company - String
        // genre - String
        // budget - int
        for (int i = 0; i < m.length; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();

            m[i] = new Movie(a, b, c, d);
        }
        String Search = sc.nextLine();
        Movie[] res = getMovieByGenre(m, Search);
        for (int i = 0; i < res.length; i++) {
            if (res[i].budget > 80000000) {
                System.out.println("High Budget Movie");
            } else {
                System.out.println("Low Budget Movie");
            }
        }
    }

    public static Movie[] getMovieByGenre(Movie[] m, String s) {
        Movie[] m1 = new Movie[0];
        for (int i = 0; i < m.length; i++) {
            if (m[i].getGenre().equalsIgnoreCase(s)) {
                // System.out.println("Matchrs");
                m1 = Arrays.copyOf(m1, m1.length + 1);
                m1[m1.length - 1] = m[i];

            }
        }
        return m1;
    }
}
