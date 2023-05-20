import java.util.Scanner;

object basic_math {
    def main(args: Array[String]) : Unit = {
        var scanner = new Scanner(System.in);
        
        print("\n\n");
        print("\tAverage of Five Numbers");
        print("\n\n");
        print("\tEnter the first number : ");
        var a: Double = scanner.nextInt();
        print("\tEnter the second number : ");
        var b: Double = scanner.nextInt();
        print("\tEnter the third number : ");
        var c: Double = scanner.nextInt();
        print("\tEnter the fourth number : ");
        var d: Double = scanner.nextInt();
        print("\tEnter the fifth number : ");
        var e: Double = scanner.nextInt();

        var average: Double = (a+b+c+d+e)/5;

        println("\tThe average of " + a + ", " + b + ", " + c + ", " + d + " and " + e + " is " + average + ".")
    }
}
