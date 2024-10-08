public class Recursion {
    public static void main(String[] args) {
        double ans = myPow(2,10);
        System.out.println(ans);
    }
    public static double myPow(double x, long n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 1 / myPow(x, -n);
        if (n % 2 == 1)
          return x * myPow(x, n - 1);
        return myPow(x * x, n / 2);
    }
}
