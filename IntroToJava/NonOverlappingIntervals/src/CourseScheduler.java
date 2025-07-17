public class CourseScheduler {
    public static void sortByFinishingTime(int[][] courses,int low, int high)
    {
        if(low<high)
        {
            int pp = partition(courses,low,high);
            sortByFinishingTime(courses,low,pp-1);
            sortByFinishingTime(courses,pp+1,high);
        }


    }
    private static int partition(int[][] arr,int low, int high)
    {
        int[] pivot = arr[high];
        int i = low;
        for (int j = low; j <=high ; j++)
        {
            if (arr[j][1]<pivot[1])
            {
                int[] temp = arr[i];
                arr[i]=arr[j];
                arr[j] = temp;
                i++;
            }

        }
        int[] temp = arr[i];
        arr[i]=arr[high];
        arr[high] = temp;
        return i;
    }
    public static int maxNonOverlappingIntervals(int[][] courses)
    {
        sortByFinishingTime(courses,0,courses.length-1);
        int count=0;
        int latestFinish=0;
        for (int i = 0; i < courses.length; i++)
        {
            if (courses[i][0]>=latestFinish)
            {
                count++;
                latestFinish=courses[i][1];

            }
        }
        return count;



    }

    public static void main(String[] args)
    {
        System.out.println(maxNonOverlappingIntervals(new int[][]{{19,20}}));

    }
}
