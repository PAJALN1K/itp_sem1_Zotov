public class Module1 {
    public static float convert(int x) {
        return x * 3.785f;
    }

    public static int fitCalc(int mins, int intensity) {
        return mins * intensity;
    }

    public static int containers(int box_num, int meshok_num, int bochka_num) {
        int box = 20;
        int meshok = 50;
        int bochka = 100;

        return box * box_num + meshok * meshok_num + bochka * bochka_num;
    }

    public static String triangleType(int x, int y, int z) {
        if ((x + y > z) && (x + z > y) && (y + z > x)) {
            if ((x == y) && (y == z)) {
                return "isosceles";
            } else if ((x == y) | (y == z) | (z == x)) {
                return "equilateral";
            } else {
                return "different-sided";
            }
        } else {
            return "not a triangle";
        }
    }

    public static int ternaryEvaluation(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int howManyItems(float n, float w, float h) {
        return (int)((n / 2) / (w*h));
    }
    // !!!

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n-1) * n;
        }
    }

    public static int gcd(int a, int b) {
        int gcd = 1;
        for (int i = 1; i < Math.max(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static int ticketSaler(int num, int price) {
        return (int)(num * price * 0.72);
    }

    public static int tables(int students, int tableTables) {
        int freeTables = students - tableTables * 2;
        if (freeTables <= 0) return 0;
        return (freeTables + 1) / 2;
    }
}
