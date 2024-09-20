import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Привет. Я калькулятор");
        System.out.println("введи свое выражение, которое необходимо посчитать (например 1+2):");
        String inp = scn.nextLine();
        try {
            String res = calc(inp);
            System.out.println("ответ:" + res);
        } catch (Exception e) {
            System.out.println("ошибка:" + e.getMessage());
        }
    }

    public static String calc(String inp) throws Exception {
        String[] s = inp.split(" ");
        int n1 = Integer.parseInt(s[0]);
        int n2 = Integer.parseInt(s[2]);
        if (n2 == 0) {
            throw new Exception("деление на ноль запрещено");
        }
        if (n1 < 1 || n2 > 10 || n2 < 1 || n2 > 10)
            throw new Exception("числа должны быть в диапозоне от 1 до 10");
        char o = s[1].charAt(0);
        int res = switch (o) {
            case '+' -> n1 + n2;
            case '-' -> n1 - n2;
            case '*' -> n1 * n2;
            case '/' -> n1 / n2;
            default -> throw new Exception("неподдерживаемый знак. используйте +, -, *, /.");
        };
        return String.valueOf(res);
    }
}