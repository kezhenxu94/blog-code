package me.kezhenxu94.blog;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

/**
 * Created by kid on 2018/4/21.
 *
 * @author kezhenxu (kezhenxu94 at 163 dot com)
 */
public class MissingNumber {
    public static void main(String[] args) {
        final Random random = new Random();

        int[] numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = random.nextInt(100) + 1;
        }

        final BitSet presence = new BitSet(101);
        for (int number : numbers) {
            presence.set(number);
        }

        System.out.println(Arrays.toString(numbers));

        for (int i = 1; i <= 100; i++) {
            if (!presence.get(i)) {
                System.out.println(i);
            }
        }
    }
}
