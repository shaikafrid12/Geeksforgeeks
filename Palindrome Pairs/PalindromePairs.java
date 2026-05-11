import java.util.HashMap;

class Solution {

    static boolean isPalindrome(String s, int i, int j) {

        while(i < j) {

            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static boolean palindromePair(String[] arr) {

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for(int i = 0; i < arr.length; i++) {

            String s = arr[i];

            for(int j = 0; j <= s.length(); j++) {

                String left = s.substring(0, j);
                String right = s.substring(j);

                // left palindrome
                if(isPalindrome(left, 0, left.length() - 1)) {

                    String revRight =
                        new StringBuilder(right)
                        .reverse()
                        .toString();

                    if(map.containsKey(revRight) &&
                       map.get(revRight) != i) {
                        return true;
                    }
                }

                // right palindrome
                if(j != s.length() &&
                   isPalindrome(right, 0, right.length() - 1)) {

                    String revLeft =
                        new StringBuilder(left)
                        .reverse()
                        .toString();

                    if(map.containsKey(revLeft) &&
                       map.get(revLeft) != i) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        scanner sc = new scanner(System.in);

        String[] arr = {"geekf", "geeks", "or", "keeg", "abc", "bc"};
        System.out.println(palindromePair(arr));

        String[] arr2 = {"abc", "xyxcba", "geekst", "or", "bc"};
        System.out.println(palindromePair(arr2));

        String[] arr3 = {"aa"};
        System.out.println(palindromePair(arr3));

    }
}