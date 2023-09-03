import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ZeroSumFinder {
    private int[] inputArray;

    public ZeroSumFinder(int[] inputArray) {
        this.inputArray = inputArray;
    }

    public List<Integer> findZeroSumElements() {
        List<Integer> result = new ArrayList<>();
        int n = inputArray.length;

        for (int i = n-2; i >= 0; i--) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (inputArray[i] + inputArray[j] + inputArray[k] == 0) {
                        result.add(inputArray[i]);
                        result.add(inputArray[j]);
                        result.add(inputArray[k]);
                        return result;
                    }
                }
            }
        }

        return result;
    }
}

public class Finder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inputArray = new int[n];
        for(int i=0; i<n; i++) {
            inputArray[i]= sc.nextInt();
        }
        ZeroSumFinder finder = new ZeroSumFinder(inputArray);

        List<Integer> zeroSumElements = finder.findZeroSumElements();

        if (!zeroSumElements.isEmpty()) {
            System.out.println("Elements whose sum is 0: " + zeroSumElements);
        } else {
            System.out.println("No Elements found");
        }
    }
}
