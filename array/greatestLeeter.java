class Solution {
    public String greatestLetter(String s) {
        int low = 0, up = 0;

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                low |= 1 << (ch - 'a');
            } else if (ch >= 'A' && ch <= 'Z') {
                up |= 1 << (ch - 'A');
            }
        }

        // Check from Z to A (25 to 0)
        for (int i = 25; i >= 0; i--) {
            if (((low >> i) & 1) == 1 && ((up >> i) & 1) == 1) {
                return String.valueOf((char)(i + 'A'));
            }
        }

        return "";
    }
}
