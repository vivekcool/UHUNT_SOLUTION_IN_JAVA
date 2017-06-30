
import java.util.*;
import java.util.stream.Collector;

public class A {

    static int val [] = {1 , 5 , 10 , 25 , 50};
    static long memo[][];
    public static long dp (int idx , int rem)
    {
        if (idx == 5)
            if (rem == 0) return 1;
            else return 0;
        if (rem == 0) return 1;

        if (memo[idx][rem] != -1) return memo[idx][rem];
        return memo[idx][rem] = (val[idx] <= rem ? dp(idx , rem - val[idx]) : 0) + dp(idx + 1 , rem);
    }
    public static void main(String [] args) throws  Exception
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        memo = new long[5][30001];
        for (int i = 0 ; i < 5 ; ++i) Arrays.fill(memo[i] , -1);
        int t = 0;
        while (sc.ready())
        {
            int n = sc.nextInt();
            long res = dp(0 , n);
            if (res != 1)
                out.printf("There are %d ways to produce %d cents change.\n" , res , n);
            else out.printf("There is only %d way to produce %d cents change.\n" , res , n);
        }
        out.flush();
        out.close();
    }









    
}
