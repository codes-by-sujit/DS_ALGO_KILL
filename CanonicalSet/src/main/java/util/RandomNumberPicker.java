package util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RandomNumberPicker {
    // Raw list – duplicates included intentionally (they are de-duplicated at runtime)
    private static final int[] RAW_NUMBERS = {
            344, 125, 680, 977, 11, 26, 27, 283, 80, 167, 611, 881, 16, 15, 18,
            141, 142, 876, 160, 234, 42, 986, 844, 392, 643, 438, 567, 239, 346,
            3, 424, 1004, 209, 1695, 340, 159, 992, 1248, 930, 713, 1358, 862,
            1425, 560, 1423, 30, 94, 144, 145, 102, 107, 104, 110, 112, 101, 222,
            113, 124, 437, 257, 105, 106, 226, 114, 98, 700, 230, 235, 236, 863,
            543, 337, 250, 124, 297, 449, 303, 1480, 304, 724, 2574, 560, 930,
            1248, 974, 523, 325, 974, 525, 1371, 1590, 992, 1248, 930, 53, 918,
            1590, 2016, 304, 1074, 363, 1504, 370, 1109, 1094, 2381, 1371, 1074,
            1425, 798, 70, 746, 198, 213, 740, 53, 152, 918, 416, 494, 322, 518,
            279, 377, 474, 879, 1143, 516, 583, 72, 115, 97, 62, 63, 64, 174,
            1463, 300, 300, 673, 354, 368, 132, 312, 1547, 664, 546, 337, 968,
            124, 698, 464, 847, 1235, 1425, 741, 1770, 357, 1012, 2376, 455, 121,
            122, 1323, 435, 56, 452, 1288, 55, 45, 1326, 1353, 621, 630, 767,
            763, 402, 316, 881, 134, 135, 871, 1383, 502, 798, 870, 2366, 78, 90,
            77, 46, 47, 39, 40, 216, 17, 131, 93, 282, 37, 51, 52, 79, 212, 980,
            60, 89, 22, 473, 698, 526, 301, 291, 1849, 704, 35, 34, 367, 374, 33,
            81, 153, 154, 162, 852, 540, 268, 875, 410, 1011, 2187, 1283, 74, 240,
            378, 719, 862, 4, 230, 300, 20, 225, 232, 1047, 844, 150, 224, 227,
            394, 496, 503, 739, 901, 907, 84, 85, 42, 402, 316, 1081, 735, 636,
            946, 155, 895, 1381, 206, 203, 237, 83, 876, 141, 142, 160, 234, 92,
            25, 24, 61, 21, 23, 2, 445, 86, 328, 19, 148, 147, 138, 430, 146,
            460, 703, 215, 973, 347, 1046, 23, 632, 373, 378, 253, 621, 1353, 630,
            295, 480, 703, 871, 1383, 502, 743, 787, 1631, 778, 218, 767
    };

    public static void main(String[] args) {
        // Build a deduplicated, shuffled list
        List<Integer> pool = buildPool();
        int total = pool.size();

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║        Random Number Picker              ║");
        System.out.printf ("║  %d unique numbers loaded               ║%n", total);
        System.out.println("║  Press 'n' + Enter → next number        ║");
        System.out.println("║  Press 'q' + Enter → quit               ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int given = 0;

        while (true) {
            System.out.print("» ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "n" -> {
                    if (pool.isEmpty()) {
                        System.out.println("✅  All " + total + " numbers have been given. No more left!");
                    } else {
                        int number = pool.removeFirst();
                        given++;
                        System.out.printf("🎲  #%-4d  →  %d%n", given, number);
                        System.out.printf("    (%d remaining)%n", pool.size());
                    }
                }
                case "q" -> {
                    System.out.println("Goodbye! " + given + " number(s) were given.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("  Unknown command. Press 'n' for next number or 'q' to quit.");
            }
        }
    }

    /**
     * Deduplicate RAW_NUMBERS, then shuffle the result so every run
     * (and every 'n' press) delivers a different order.
     */
    private static List<Integer> buildPool() {
        // LinkedHashSet would preserve insertion order during dedup; we shuffle anyway.
        List<Integer> unique = new ArrayList<>();
        boolean[] seen = new boolean[10_000]; // numbers are all well below 10 000

        for (int n : RAW_NUMBERS) {
            if (n >= 0 && n < seen.length && !seen[n]) {
                seen[n] = true;
                unique.add(n);
            }
        }

        Collections.shuffle(unique);
        return unique;
    }
}
