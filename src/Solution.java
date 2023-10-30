import java.math.BigInteger;

class Solution {

    public static void main(String[] args) {
        long c = 1600851475143L;
        long max = 0;
        for (long i = 2; i <= Math.sqrt(c); i++) {
            if(c%i==0){
                boolean check = true;
                long bigger = c/i;
                for (long j = 2; j <= Math.sqrt(bigger); j++) {
                    if(bigger%j==0) {
                        check = false;
                        break;
                    }
                }
                if(check) max = Math.max(max,bigger);
            }
        }
        System.out.println(max);
    }
}