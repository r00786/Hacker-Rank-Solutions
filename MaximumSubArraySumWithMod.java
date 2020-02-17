import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaximumSubArraySumWithMod{

static long maximumSum(long[] a, long m) {
        long[] sums = buildSums(a, m);

        long result = Arrays.stream(sums).max().getAsLong();
        NavigableSet<Long> sortedSums = new TreeSet<>();
        for (long sum : sums) {
            Long higher = sortedSums.higher(sum);
            if (higher != null) {
                result = Math.max(result, addMod(sum, -higher, m));
            }

            sortedSums.add(sum);
        }
        return result;
    }

    static long[] buildSums(long[] a, long m) {
        long[] sums = new long[a.length];
        long sum = 0;
        for (int i = 0; i < sums.length; i++) {
            sum = addMod(sum, a[i], m);
            sums[i] = sum;
        }
        return sums;
    }

    static long addMod(long x, long y, long modulus) {
        return ((x + y) % modulus + modulus) % modulus;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
