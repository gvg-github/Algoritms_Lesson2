
/* Гурьевских В.Г.

(Task1) 1. Реализовать функцию перевода из 10 системы в двоичную используя рекурсию.

(Task2) 2. Реализовать функцию возведения числа a в степень b:

        a. без рекурсии;
        b. рекурсивно;
        c. *рекурсивно, используя свойство чётности степени.

(Task3) 3. Первая команда увеличивает число на экране на 1, вторая увеличивает это число в 2 раза.
            Сколько существует программ, которые число 3 преобразуют в число 20.
        а) с использованием массива;
        б) с использованием рекурсии.

*/

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        //Реализовать функцию перевода из 10 системы в двоичную используя рекурсию
        Task1();

        //Реализовать функцию возведения числа a в степень b
        Task2();

        //Сколько существует программ, которые число 3 преобразуют в число 20.
        Task3();

    }

    //Сколько существует программ, которые число 3 преобразуют в число 20.
    private static void Task3() {

        int x = 3;
        int y = 6;

        int count = calculateWays(x, y);
        System.out.println(count);

    }

    //Расчет вариантов получения 20 из 3 через рекурсию
    private static int calculateWays(int x, int y) {
        int count = 0;
        if (x < y) {

            int z = x + 1;
            int xx = x * 2;
            if (z == y) {
                count++;
            } else count += calculateWays(z, y);

            if (xx == y) {
                count++;
            } else {
                if (xx < y) count += calculateWays(xx, y);
            }
        }
        return count;

    }

    //Реализовать функцию возведения числа a в степень b
    private static void Task2() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number:");
        int x = in.nextInt();
        System.out.print("Input degree:");
        int y = in.nextInt();

//        int x = 2;
//        int y = 5;

        //Без рекурсии
        expWithoutRec(x, y);

        //С рекурсией
        expWithRec(x, x, y, y);

        //С учетом свойства степени
        expWithRecWithProperty(x, x * x, y - 2, y);

    }

    //Возведение в степень через рекурсию c учетом свойств степени
    private static void expWithRecWithProperty(int i, int x, int y, int y1) {
        if (y > 2) {
            x *= x;
            y -= 2;
            expWithRecWithProperty(i, x, y, y1);
        } else if (y == 1) {
            x *= i;
            y--;
            expWithRecWithProperty(i, x, y, y1);
        } else {
            System.out.println(i + "^" + y1 + " = " + x + ", property");
        }
    }

    //Возведение в степень через рекурсию
    private static void expWithRec(int i, int x, int y, int y1) {

        if (y > 1) {
            x *= i;
            y--;
            expWithRec(i, x, y, y1);
        } else {
            System.out.println(i + "^" + y1 + " = " + x);
        }

    }

    //Возведение в степень через цикл
    private static void expWithoutRec(int x, int y) {
        int x1 = x;
        int y1 = y;
        while (y > 1) {
            x *= x1;
            y--;
        }
        System.out.println(x1 + "^" + y1 + " = " + x + ", no rec");
    }

    //Реализовать функцию перевода из 10 системы в двоичную используя рекурсию
    private static void Task1() {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
//        int x = 254;
        int y = x;
        System.out.println("Number " + y + ", " + Integer.toBinaryString(x) + ", formatted with function");
        StringBuilder sb = new StringBuilder();

        sb.append("");

        formatNimber(x, sb);
        sb.reverse();
        System.out.println("Number " + y + ", " + sb.toString());
    }

    //Перевод в двоичную систему через рекурсию
    private static void formatNimber(int x, StringBuilder sbR) {
        sbR.append(x % 2);

        if (x / 2 != 0) {
            x /= 2;
            formatNimber(x, sbR);
        }
    }
}
