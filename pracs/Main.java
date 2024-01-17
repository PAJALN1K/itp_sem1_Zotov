import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
//        printModule1();
//        printModule2();
//        printModule3();
//        printModule4();
        printModule5();
//        printModule6();
    }

    public static void printModule1 () {
        System.out.println("\nConvert");
        System.out.println(Module1.convert(5));
        System.out.println(Module1.convert(3));
        System.out.println(Module1.convert(8));

        System.out.println("\nfitCalc");
        System.out.println(Module1.fitCalc(15, 1));
        System.out.println(Module1.fitCalc(24, 2));
        System.out.println(Module1.fitCalc(41, 3));

        System.out.println("\nContainers");
        System.out.println(Module1.containers(3, 4, 2));
        System.out.println(Module1.containers(5, 0, 2));
        System.out.println(Module1.containers(4, 1, 4));

        System.out.println("\ntriangleType");
        System.out.println(Module1.triangleType(5,5, 5));
        System.out.println(Module1.triangleType(5,4, 5));
        System.out.println(Module1.triangleType(3,4, 5));
        System.out.println(Module1.triangleType(5,1, 1));

        System.out.println("\nternaryEvaluation");
        System.out.println(Module1.ternaryEvaluation(8, 4));
        System.out.println(Module1.ternaryEvaluation(1, 11));
        System.out.println(Module1.ternaryEvaluation(5, 9));

        System.out.println("\nhowManyItems");
        System.out.println(Module1.howManyItems(22, 1.4f, 2));
        System.out.println(Module1.howManyItems(45, 1.8f, 1.9f));
        System.out.println(Module1.howManyItems(100, 2, 2));

        System.out.println("\nfactorial");
        System.out.println(Module1.factorial(3));
        System.out.println(Module1.factorial(5));
        System.out.println(Module1.factorial(7));

        System.out.println("\ngcd");
        System.out.println(Module1.gcd(48, 18));
        System.out.println(Module1.gcd(52, 8));
        System.out.println(Module1.gcd(259, 28));

        System.out.println("\nticketSaler");
        System.out.println(Module1.ticketSaler(70, 1500));
        System.out.println(Module1.ticketSaler(24, 950));
        System.out.println(Module1.ticketSaler(53, 1250));

        System.out.println("\ntables");
        System.out.println(Module1.tables(5, 2));
        System.out.println(Module1.tables(31, 20));
        System.out.println(Module1.tables(123, 58));
    }

    public static void printModule2() {
        System.out.println("\nduplicateChars");
        System.out.println(Module2.dublicateChars("Donald") );
        System.out.println(Module2.dublicateChars("orange"));

        System.out.println("\ngetInitials");
        System.out.println(Module2.getInitials("Ryan Gosling"));
        System.out.println(Module2.getInitials("Barack Obama"));

        System.out.println("\ndifferenceEvenOdd");
        System.out.println(Module2.differenceEvenOdd(new int[] {44, 32, 86, 19}));
        System.out.println(Module2.differenceEvenOdd(new int[] {22, 50, 16, 63, 31, 55}));

        System.out.println("\nequalToAvg");
        System.out.println(Module2.equalToAvg(new int[] {1, 2, 3, 4, 5}));
        System.out.println(Module2.equalToAvg (new int[] {1, 2, 3, 4, 6}));

        System.out.println("\nindexMult");
        System.out.println(Arrays.toString(Module2.indexMult(new int[] {1, 2, 3})));
        System.out.println(Arrays.toString(Module2.indexMult(new int[] {3, 3, -2, 408, 3, 31})));

        System.out.println("\nreverse");
        System.out.println(Module2.reverse("Hello World"));
        System.out.println(Module2.reverse("The quick brown fox.") );

        System.out.println("\nTribonacci");
        System.out.println(Module2.Tribonacci(7));
        System.out.println(Module2.Tribonacci(11));

        System.out.println("\npseudoHash");
        System.out.println(Module2.pseudoHash(5));
        System.out.println(Module2.pseudoHash(10));
        System.out.println(Module2.pseudoHash(0));

        System.out.println("\nbotHelper");
        System.out.println(Module2.botHelper("Hello, I’m under the water, please help me"));
        System.out.println(Module2.botHelper("Two pepperoni pizzas please"));
        System.out.println(Module2.botHelper("!help/"));

        System.out.println("\nisAnagram");
        System.out.println(Module2.isAnagram("listen", "silent"));
        System.out.println(Module2.isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(Module2.isAnagram("hello", "world") );
    }

    public static void printModule3() {
        System.out.println("\nreplaceVovels");
        System.out.println(Module3.replaceVovels("apple"));
        System.out.println(Module3.replaceVovels("Even if you did this  task not by yourself, you have to understand every single line of code"));

        System.out.println("\nstringTransform");
        System.out.println(Module3.stringTransform("hello"));
        System.out.println(Module3.stringTransform("bookkeeper"));

        System.out.println("\ndoesBlockFit");
        System.out.println(Module3.doesBlockFit(new int[] {3, 1, 5}, new float[] {5, 4}));
        System.out.println(Module3.doesBlockFit(new int[] {1, 8, 1}, new float[] {1, 1}));
        System.out.println(Module3.doesBlockFit(new int[] {1, 2, 2}, new float[] {1, 1}));

        System.out.println("\nnumCheck");
        System.out.println(Module3.numCheck(243));
        System.out.println(Module3.numCheck(52));

        System.out.println("\ncountRoots");
        System.out.println(Module3.countRoots(new int[] {1, -3, 2}));
        System.out.println(Module3.countRoots(new int[] {2, 5, 2}));
        System.out.println(Module3.countRoots(new int[] {1, -6, 9}));

        System.out.println("\nsalesData");
        Module3.salesData(new String[][] {
            {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
            {"Banana", "Shop2", "Shop3", "Shop4"},
            {"Orange", "Shop1", "Shop3", "Shop4"},
            {"Pear", "Shop2", "Shop4"}
        });
       Module3.salesData(new String[][] {
            {"Fridge", "Shop2", "Shop3"},
            {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
            {"Laptop", "Shop3", "Shop4"},
            {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
       });

        System.out.println("\nvalidSplit");
        System.out.println(Module3.validSplit("apple eagle egg goat"));
        System.out.println(Module3.validSplit(("cat dog goose fish")));

        System.out.println("\nwaveForm");
        System.out.println(Module3.waveForm(new int[] {3, 1, 4, 2, 7, 5}));
        System.out.println(Module3.waveForm(new int[] {1, 2, 3, 4, 5}));
        System.out.println(Module3.waveForm(new int[] {1, 2, -6, 10, 3}));

        System.out.println("\ncommonVovel");
        System.out.println(Module3.commonVowel("Hello world"));
        System.out.println(Module3.commonVowel("Actions speak louder than words."));

        System.out.println("\ndataScience");
        Module3.dataScience(new int[][] {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 29, 10},
            {5, 5, 5, 5, 35},
            {7, 4, 3, 14, 2},
            {1, 0, 11, 10, 1}
        });
        Module3.dataScience(new int[][] {
            {6, 4, 19, 0, 0},
            {81, 25, 3, 1, 17},
            {48, 12, 60, 32, 14},
            {91, 47, 16, 65, 217},
            {5, 73, 0, 4, 21}
        });
    }

    public static void printModule4() {
        System.out.println("\nnonRepeatable");
        System.out.println(Module4.nonRepeatable("abracadabra"));
        System.out.println(Module4.nonRepeatable("paparazzi"));

        System.out.println("\ngenerateBrackets");
        System.out.println(Module4.generateBrackets(1));
        System.out.println(Module4.generateBrackets(2));
        System.out.println(Module4.generateBrackets(3));
        System.out.println(Module4.generateBrackets(4));

        System.out.println("\nbinarySystem");
        System.out.println(Module4.binarySystem(2));
        System.out.println(Module4.binarySystem(3));
        System.out.println(Module4.binarySystem(4));

        System.out.println("\nalphabeticRow");
        System.out.println(Module4.alphabeticRow("abcdjuwx"));
        System.out.println(Module4.alphabeticRow("klmabzyxw"));

        System.out.println("\ncrazySort");
        System.out.println(Module4.crazySort("aaabbcdd"));
        System.out.println(Module4.crazySort("vvvvaajaaaaa"));

        System.out.println("\nconvertToNum");
        System.out.println(Module4.convertToNum("eight"));
        System.out.println(Module4.convertToNum("five hundred sixty seven"));
        System.out.println(Module4.convertToNum("thirty one"));

        System.out.println("\nuniqueSubstring");
        System.out.println(Module4.uniqueSubstring("123412324"));
        System.out.println(Module4.uniqueSubstring("111111"));
        System.out.println(Module4.uniqueSubstring("77897898"));

        System.out.println("\nshortestWay");
        System.out.println(Module4.shortestWay(new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
        System.out.println(Module4.shortestWay(new int[][] {
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}
        }));

        System.out.println("\nnumericOrder");
        System.out.println(Module4.numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(Module4.numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println("\nswitchNums");
        System.out.println(Module4.switchNums(519, 723));
        System.out.println(Module4.switchNums(491, 3912));
        System.out.println(Module4.switchNums(6274, 71259));
    }

    public static void printModule5() {
        System.out.println("\nsameLetterPattern");
        System.out.println(Module5.sameLetterPattern("ABAB", "CDCD"));
        System.out.println(Module5.sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(Module5.sameLetterPattern("FFGG", "CDCD"));
        System.out.println(Module5.sameLetterPattern("FFFF", "ABCD"));

        System.out.println("\nspiderVsFly");
        System.out.println(Module5.spiderVsFly("H3", "E2"));
        System.out.println(Module5.spiderVsFly("A4", "B2"));
        System.out.println(Module5.spiderVsFly("A4", "C2"));
        System.out.println(Module5.spiderVsFly("C2", "A4")); //муха дальше, чем паук от центра + обратное направление
        System.out.println(Module5.spiderVsFly("H4", "A3")); //муха ближе, направление обратное
        System.out.println(Module5.spiderVsFly("G4", "A3")); //муха ближе, ещё одно обратное
        System.out.println(Module5.spiderVsFly("H3", "H3")); //нахождение в одной точке
        System.out.println(Module5.spiderVsFly("H3", "D3"));
        System.out.println(Module5.spiderVsFly("A3", "H3")); //шаг назад через граничный случай
        System.out.println(Module5.spiderVsFly("A3", "G3")); //два шага назад через граничный случай
        System.out.println(Module5.spiderVsFly("C4", "E4")); //два шага вперёд

        System.out.println("\ndigitsCount");
        System.out.println(Module5.digitsCount(4666));
        System.out.println(Module5.digitsCount(544));
        System.out.println(Module5.digitsCount(121317));
        System.out.println(Module5.digitsCount(0));
        System.out.println(Module5.digitsCount(12345));
        System.out.println(Module5.digitsCount(1289396387328L));

        System.out.println("\ntotalPoints");
        System.out.println(Module5.totalPoints(new String[] {"cat", "create", "sat"}, "caster"));
        System.out.println(Module5.totalPoints(new String[] {"trance", "recatn"}, "recant"));
        System.out.println(Module5.totalPoints(new String[] {"trance", "recant"}, "recant"));
        System.out.println(Module5.totalPoints(new String[] {"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));

        System.out.println("\nsumsUp");
        Module5.sumsUp(new int[] {1, 2, 3, 4, 5});
        Module5.sumsUp(new int[] {1, 2, 3, 7, 9});
        Module5.sumsUp(new int[] {10, 2, 7, 2, 8});
        Module5.sumsUp(new int[] {1, 6, 5, 4, 8, 2, 3, 7});

        System.out.println("\ntakeDownAverage");
        System.out.println(Module5.takeDownAverage(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(Module5.takeDownAverage(new String[] {"10%"}));
        System.out.println(Module5.takeDownAverage(new String[] {"53%", "79%"}));

        System.out.println("\ncaesarCipher");
        System.out.println(Module5.caesarCipher("encode", "hello world", 3));
        System.out.println(Module5.caesarCipher("decode", "almost last task!", 4));

        System.out.println("\nsetSetup");
        System.out.println(Module5.setSetup(5, 3));
        System.out.println(Module5.setSetup(7, 3));

        System.out.println("\ntimeDifference");
        System.out.println(Module5.timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(Module5.timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(Module5.timeDifference("Beijing", "December 31, 1970 13:40", "New Delhi") );
        System.out.println(Module5.timeDifference("New Delhi", "December 31, 1970 13:40", "Beijing") );
        System.out.println(Module5.timeDifference("New York", "December 31, 1970 13:40", "Beijing") );

        System.out.println("\nisNew");
        System.out.println(Module5.isNew(3));
        System.out.println(Module5.isNew(30));
        System.out.println(Module5.isNew(321));
        System.out.println(Module5.isNew(1203));
    }

    public static void printModule6() {
        System.out.println("\nhiddenAnagram");
        System.out.println(Module6.hiddenAnagram(new String[] {"My world evolves in a beautiful space called Tesh.", "sworn love lived"}));
        System.out.println(Module6.hiddenAnagram(new String[] {"An old west action hero actor", "Clint Eastwood"}));
        System.out.println(Module6.hiddenAnagram(new String[] {"Mr. Mojo Rising could be a song title", "Jim Morrison"}));
        System.out.println(Module6.hiddenAnagram(new String[] {"Banana? margaritas", "ANAGRAM"}));
        System.out.println(Module6.hiddenAnagram(new String[] {"D  e b90it->?$ (c)a r...d,,#~", "bad credit"}));
        System.out.println(Module6.hiddenAnagram(new String[] {"Bright is the moon", "Bongo mirth"}));

        System.out.println("\ncollect");
        System.out.println(Arrays.toString(Module6.collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(Module6.collect("strengths", 3)));
        System.out.println(Arrays.toString(Module6.collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));

        System.out.println("\nnicoCipher");
        System.out.println(Module6.nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(Module6.nicoCipher("andiloveherso", "tesha"));
        System.out.println(Module6.nicoCipher("mubashirhassan", "crazy"));
        System.out.println(Module6.nicoCipher("edabitisamazing", "matt"));
        System.out.println(Module6.nicoCipher("iloveher", "612345"));

        System.out.println("\ntwoProduct");
        System.out.println(Arrays.toString(Module6.twoProduct(new int[] {1, 2, 3, 9, 4, 5, 15}, 45)));
        System.out.println(Arrays.toString(Module6.twoProduct(new int[] {1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(Module6.twoProduct(new int[] {1,  2, -1,  4,  5,  6,  10, 7}, 20)));
        System.out.println(Arrays.toString(Module6.twoProduct(new int[] {1, 2, 3, 4, 5,  6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(Module6.twoProduct(new int[] {100, 12, 4, 1, 2}, 15)));

        System.out.println("\nisExact");
        System.out.println(Arrays.toString(Module6.isExact(6)));
        System.out.println(Arrays.toString(Module6.isExact(24)));
        System.out.println(Arrays.toString(Module6.isExact(125)));
        System.out.println(Arrays.toString(Module6.isExact(720)));
        System.out.println(Arrays.toString(Module6.isExact(1024)));
        System.out.println(Arrays.toString(Module6.isExact(40320)));

        System.out.println("\nfractions");
        System.out.println(Module6.fractions("0.(6)"));
        System.out.println(Module6.fractions("1.(1)"));
        System.out.println(Module6.fractions("3.(142857)"));
        System.out.println(Module6.fractions("0.19(2367)"));
        System.out.println(Module6.fractions("0.1097(3)"));

        System.out.println("\npilishString");
        System.out.println(Module6.pilishString("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
        System.out.println(Module6.pilishString("FORALOOP"));
        System.out.println(Module6.pilishString("CANIMAKEAGUESSNOW"));
        System.out.println(Module6.pilishString("33314444"));
        System.out.println(Module6.pilishString("TOP"));
        System.out.println(Module6.pilishString("X"));
        System.out.println(Module6.pilishString(""));

        System.out.println("\ngenerateNonconsecutive");
        System.out.println(Module6.generateNonconsecutive("3 + 5 * (2 - 6)"));                  // -17
        System.out.println(Module6.generateNonconsecutive("6 - 18 / (-1 + 4)"));                // 0
        System.out.println(Module6.generateNonconsecutive("-2 * (-4) + 10 / ((2 - 3) * 3)"));   // 4,667
        System.out.println(Module6.generateNonconsecutive("(-(-(-5)))"));                       //-5
        System.out.println(Module6.generateNonconsecutive("-(-(-5))"));                         //-5
        System.out.println(Module6.generateNonconsecutive("2 + 3 * 4"));                        //14
        System.out.println(Module6.generateNonconsecutive("10 / 0"));                           // division by zero
        System.out.println(Module6.generateNonconsecutive("4 * 3 / (6 - 4) +"));                // superfluous operation
        System.out.println(Module6.generateNonconsecutive("((2 + 3) * 4"));                     // brackets at inappropriate place
        System.out.println(Module6.generateNonconsecutive("7 / 2.5"));                          // 2.8
        System.out.println(Module6.generateNonconsecutive("2 + abc * 3"));                      // illegal symbol
        System.out.println(Module6.generateNonconsecutive("5 + * 2"));                          // operands at inappropriate place
        System.out.println(Module6.generateNonconsecutive("5 + / 2"));                          // operands at inappropriate place
        System.out.println(Module6.generateNonconsecutive("-5-(-3)"));                          //-2
        System.out.println(Module6.generateNonconsecutive("-3*-7"));                            // operands at inappropriate place
        System.out.println(Module6.generateNonconsecutive("(((-8)))"));                         //-8
        System.out.println(Module6.generateNonconsecutive("2.5*2.5"));                          //6.25
        System.out.println(Module6.generateNonconsecutive("2.5/2.5"));                          //1
        System.out.println(Module6.generateNonconsecutive("2.5+2.5"));                          //5
        System.out.println(Module6.generateNonconsecutive("2.5-2.5"));                          //0
        System.out.println(Module6.generateNonconsecutive("7/3*4"));                            //9.333
        System.out.println(Module6.generateNonconsecutive("5*2/3"));                            //3.3333
        System.out.println(Module6.generateNonconsecutive("5-2+3"));                            //6
        System.out.println(Module6.generateNonconsecutive("5+2-3*4/2-1"));                      //0

        System.out.println("\nisValid");
        System.out.println(Module6.isValid("aabbcd"));
        System.out.println(Module6.isValid("aabbccddeefghi"));
        System.out.println(Module6.isValid("abcdefghhgfedecba"));

        System.out.println("\nfindLCS");
        System.out.println(Module6.findLCS("abcd", "bd"));
        System.out.println(Module6.findLCS("aggtab", "gxtxamb"));
    }
}
