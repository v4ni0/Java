package bg.sofia.uni.fmi.mjt;

public class Project
{
    private static final String Prefix = "MJT_Project";
    private static int instances;
    private final String name;
    public String getName()
    {
        return name;
    }
    public Project()
    {
        name= Prefix + "_" + instances++;
    }

    public static void main(String[] args) {
        System.out.println(new Project().getName());
        System.out.println(new Project().getName());
        System.out.println(new Project().getName());
    }
}
