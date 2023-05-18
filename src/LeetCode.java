import java.util.*;

public class LeetCode {

    public static int romanToInt(String s) {
        int year = 0;

        boolean skip = false;
        for (int i = 0; i < s.length(); i++) {
            if (skip) {
                skip = false;
                continue;
            }

            switch (Character.toUpperCase(s.charAt(i))) {
                case 'I' -> {
                    if (i + 1 <= s.length() - 1) {
                        if (Character.toUpperCase(s.charAt(i + 1)) == 'V') {
                            year += 4;
                            skip = true;
                        } else if (Character.toUpperCase(s.charAt(i + 1)) == 'X') {
                            year += 9;
                            skip = true;
                        } else {
                            year += 1;
                        }
                    } else {
                        year += 1;
                    }
                }

                case 'V' -> year += 5;
                case 'X' -> {
                    if (i + 1 <= s.length() - 1) {
                        if (Character.toUpperCase(s.charAt(i + 1)) == 'L') {
                            year += 40;
                            skip = true;
                        } else if (Character.toUpperCase(s.charAt(i + 1)) == 'C') {
                            year += 90;
                            skip = true;
                        } else {
                            year += 10;
                        }
                    } else {
                        year += 10;
                    }

                }
                case 'L' -> year += 50;
                case 'C' -> {
                    if (i + 1 <= s.length() - 1) {
                        if (Character.toUpperCase(s.charAt(i + 1)) == 'D') {
                            year += 400;
                            skip = true;
                        } else if (Character.toUpperCase(s.charAt(i + 1)) == 'M') {
                            year += 900;
                            skip = true;
                        } else {
                            year += 100;
                        }
                    } else {
                        year += 100;
                    }
                }
                case 'D' -> year += 500;
                case 'M' -> year += 1000;
            }
        }

        return year;
    }

    public static String longestCommonPrefix(String[] strs) {
        String longest = "";

        if (strs.length == 1) return strs[0];

        for (String str : strs) {
            for (int j = 0; j <= str.length(); j++) {
                String txt = str.substring(0, j);

                boolean allMatch = Arrays.stream(strs).allMatch(p -> p.startsWith(txt));

                if (allMatch) longest = txt;
            }
        }

        return longest;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    public static int lengthOfLongestSubstring(String s) {
        int counter = 1;
        TreeSet<Integer> nums = new TreeSet<>();
        List<Character> symbols = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length()) {
                if (!symbols.contains(s.charAt(i + 1))) {
                    if (s.charAt(i) != s.charAt(i + 1)) {
                        counter++;
                        symbols.add(s.charAt(i));
                        nums.add(counter);
                    } else {
                        counter = 1;
                        nums.add(counter);
                    }
                }
            } else {
                if (!symbols.contains(s.charAt(i))) {
                    counter++;
                    nums.add(counter);
                } else {
                    nums.add(counter);
                }
            }
        }

        if (nums.isEmpty()) return 0;

        return nums.last();
    }

    public static boolean isPalindrome(int x) {

        int original = x;
        int reversed = 0;

        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return original == reversed;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
