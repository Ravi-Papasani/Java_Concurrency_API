package WorkingThreads.UsingThreadMethods;

public class PrimeNumberUtil {

    public static int primeNumberValue(int n) {

        int number = 1, count = 0, i;

        while (count < n) {
            number = number + 1;
            for (i = 2; i <= number; i++) {
                //determines the modulo and compare it with 0
                if (number % i == 0) {
                    //breaks the loop if the above condition returns true
                    break;
                }
            }
            if (i == number) {
                //increments the count variable by 1 if the number is prime
                count = count + 1;
            }
        }
        return number;
    }
}
