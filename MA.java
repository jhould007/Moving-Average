import java.util.ArrayList;
import java.lang.Math; 

public class MA {
    private int maxSize;
    private ArrayList<Integer> currentWindow;
    private double sum = 0;
    private double avg;

    public MA() {
    }

    public MA(int size) {
        this.maxSize = size;
        this.currentWindow = new ArrayList<Integer>();
    }

    public void add(int n) {
        if (currentWindow.size() < maxSize) {
            currentWindow.add(n);
            sum += n;
            System.out.println(n + " has been added!");
        }
        System.out.println("The window is now " + currentWindow.toString());
        avg = round(sum / currentWindow.size());
        System.out.println("The average is now " + avg);
    }

    public void remove() {
        int finalValue = currentWindow.get(currentWindow.size() - 1);
        currentWindow.remove(currentWindow.size() - 1);
        System.out.println(finalValue + " has been removed!");
        System.out.println("The window is now " + currentWindow.toString());
        avg = round(sum / currentWindow.size());
        System.out.println("The average is now " + avg);
    }

    public String toString() {
        String a = "";
        a += "(";
        for (int i = 0; i < currentWindow.size(); i++) {
            if (i < currentWindow.size() - 1) {
                a += (currentWindow.get(i) + ", ");
            } else {
                a += currentWindow.get(i);
            }
        }
        a += ")";
        return a;
    }

    public double round(double d) {
        return Math.round(d * 100.0) / 100.0; 
    }

    public static void main(String[] args) {
        MA m = new MA(10);
        for(int i = 10; i <= 100; i += 10) {
            m.add(i); 
        }
        for(int i = 0; i < 5; i++) {
            m.remove(); 
        }
    }

    // Average should be calculated every time something is added or removed

}