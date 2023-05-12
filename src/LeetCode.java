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
                        }else {
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
                        }else {
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
}
