package bg.sofia.uni.fmi.mjt.suuper;

public class Parent
{
    int parentValue;
    Parent(int parentValue)
    {
        this.parentValue=parentValue;
    }
    void displayParent()
    {
        System.out.println("Parent value: " + parentValue);
    }
}
