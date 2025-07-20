package bg.sofia.uni.fmi.mjt.suuper;

public class Child extends Parent
{
    int childValue;
    Child(int parentValue,int childValue)
    {
        super(parentValue);
        this.childValue=childValue;
    }
    void displayChild()
    {
        System.out.println("Child value: " + childValue);
    }
    void displayParentAndChild()
    {
        super.displayParent();
        this.displayChild();
    }

    public static void main(String[] args) {
        Child child = new Child(1,10);
        child.displayParentAndChild();
    }
}
