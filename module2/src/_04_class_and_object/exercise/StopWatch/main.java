package _04_class_and_object.exercise.StopWatch;

public class main {
    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        System.out.println("start: " + stopwatch.getStartTime());
        sortRandom100000Number();
        stopwatch.end();
        System.out.println("end: " + stopwatch.getEndTime());
        System.out.println("elapse time: " + stopwatch.getElapsedTime());


    }

    public static void sortRandom100000Number() {
        SelectionSort ob = new SelectionSort();
        int arr[] = new int[100000];
        for (int i = 0; i < arr.length; i++) {
//            Double a = Math.floor(Math.random()*100000);
//            System.out.println(a);
            arr[i] = (int)(Math.floor(Math.random()*100000));
        }
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
