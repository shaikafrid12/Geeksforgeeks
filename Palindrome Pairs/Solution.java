class Solution {
    static boolean palindromepair(int n, String arr[]) {
        java.util.HashMap<String, Integer> map = new java.util.HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        for (String s : arr) {
            int len = s.length();
            for (int i = 0; i <= len; i++) {
                String left = s.substring(0, i);
                String right = s.substring(i);
                
                if (isPalindrome(left)) {
                    String target = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(target)) {
                        if (!target.equals(s) || map.get(target) > 1) {
                            return true;
                        }
                    }
                }
                
                if (isPalindrome(right)) {
                    String target = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(target)) {
                        if (!target.equals(s) || map.get(target) > 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
