import java.lang.Math;

public class one {
    public static void main(String []args){
        // You can use 1 / x < 0 to distinguish +0.0 or -0.0
        System.out.println("-1.0 / -0.0: " + Boolean.toString(-1.0 / -0.0 < 0)); // false
        System.out.println("-1.0 / +0.0: " + Boolean.toString(-1.0 / +0.0 < 0)); // true

        System.out.println("+0.0 > -0.0: " + Boolean.toString(+0.0 > -0.0));
        System.out.println("+0.0 < -0.0: " + Boolean.toString(+0.0 < -0.0));

        // https://stackoverflow.com/questions/22409102/how-do-i-check-if-a-zero-is-positive-or-negative
        // I personally like this solution because 1 / x looks very unintuitive.
        // Or there are also some methods mentioned in https://en.wikipedia.org/wiki/Signed_zero
        System.out.println(Boolean.toString(Math.copySign(1.0, +0.0) > 0)); // true
        System.out.println(Boolean.toString(Math.copySign(1.0, -0.0) > 0)); // false

        // Java floating point specification:
        // https://stackoverflow.com/questions/6724031/how-can-a-primitive-float-value-be-0-0-what-does-that-mean
        // https://en.wikipedia.org/wiki/Signed_zero
        // https://docs.oracle.com/javase/specs/jvms/se10/html/jvms-2.html#jvms-2.8.1
        // https://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.12.5
        // For type float, the default value is positive zero, that is, 0.0f. --> this means 0.0f is positive zero
        // For type double, the default value is positive zero, that is, 0.0d. --> this means 0.0d is positive zero
    }
}
