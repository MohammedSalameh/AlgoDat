package Sorting;

public class Recursion {

    public Recursion () {

    }

    //iterative approach is usually faster as it doesnt require multiple calls
    //multiple calls require overhead as each call uses memory
    public int IterativeFactorial (int num) {
        if (num == 0) {
            return 1;
        }

        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public int RecursiveFactorial (int num) {
        if (num == 0) {
            return 1;
        }

        return num * RecursiveFactorial(num-1);
    }
}
