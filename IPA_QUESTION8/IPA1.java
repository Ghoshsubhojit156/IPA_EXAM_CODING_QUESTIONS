import java.util.*;
class Document {
    int id;
    String title;
    String folderName;
    int pages;

    Document(int id, String title, String folderName, int pages) {
        this.id = id;
        this.title = title;
        this.folderName = folderName;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFolderName() {
        return folderName;
    }

    public int getPages() {
        return pages;
    }
}

public class IPA1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();sc.nextLine();
        Document[] dc=new Document[n];
        for(int i=0;i<n;i++){
            int id=sc.nextInt();sc.nextLine();
            String title=sc.nextLine();
            String folderName=sc.nextLine();
            int pages=sc.nextInt();sc.nextLine();

            dc[i]=new Document(id, title, folderName, pages);
        }
        Document[] res=docsWithOddPages(dc);
        if(res!=null){
            for(int i=0;i<res.length;i++){
                System.out.println(res[i].getId()+" "+res[i].getTitle()+" "+res[i].getFolderName()+" "+res[i].getPages());
            }
        }else{
            System.out.println("No odd pages is there");
        }
    }

    public static Document[] docsWithOddPages(Document[] dc) {
        Document[] dc1=new Document[0];
        for(int i=0;i<dc.length;i++){
            if(dc[i].getPages()%2!=0){
                dc1=Arrays.copyOf(dc1,dc1.length+1);
                dc1[dc1.length-1]=dc[i];
            }
        }
        if(dc1.length>0){
            return dc1;
        }else{
            return null;
        }
  }
}

