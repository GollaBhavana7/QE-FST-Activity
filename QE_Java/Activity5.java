package javatraining;

abstract class Book {
    String title;
    abstract void setTitle(String s);
    String getTitle()
    {
        return title;
    }
}
class MyBook extends Book{
    void setTitle(String s)
    {
        title=s;
    }
}

public class Activity5 {
public static void main(String[] args) {
    Book b=new MyBook();
    b.setTitle("Ikigai");
    System.out.println(b.getTitle());

}
}
