class AdvancedString {
    private char[] value;
    private int length;
    
    public AdvancedString(String str) {
        this.value = str.toCharArray();
        this.length = str.length();
    }
    
    // Reverse string
    public AdvancedString reverse() {
        char[] reversed = new char[length];
        for (int i = 0; i < length; i++) {
            reversed[i] = value[length - 1 - i];
        }
        return new AdvancedString(new String(reversed));
    }
    
    // Count occurrences of character
    public int countOccurrences(char ch) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (value[i] == ch) {
                count++;
            }
        }
        return count;
    }
    
    // Count occurrences of substring
    public int countOccurrences(AdvancedString substr) {
        int count = 0;
        int index = 0;
        while (index <= length - substr.length) {
            boolean found = true;
            for (int i = 0; i < substr.length; i++) {
                if (value[index + i] != substr.value[i]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                count++;
                index += substr.length;
            } else {
                index++;
            }
        }
        return count;
    }
    
    // Check if palindrome
    public boolean isPalindrome() {
        for (int i = 0; i < length / 2; i++) {
            if (value[i] != value[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
    
    // Remove duplicates
    public AdvancedString removeDuplicates() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            boolean duplicate = false;
            for (int j = 0; j < sb.length(); j++) {
                if (value[i] == sb.charAt(j)) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                sb.append(value[i]);
            }
        }
        return new AdvancedString(sb.toString());
    }
    
    // Get all substrings
    public AdvancedString[] getAllSubstrings() {
        int totalSubstrings = length * (length + 1) / 2;
        AdvancedString[] result = new AdvancedString[totalSubstrings];
        int index = 0;
        
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                char[] substr = new char[j - i];
                System.arraycopy(value, i, substr, 0, j - i);
                result[index++] = new AdvancedString(new String(substr));
            }
        }
        return result;
    }
    
    // Anagrams check
    public boolean isAnagram(AdvancedString other) {
        if (length != other.length) return false;
        
        int[] count1 = new int[256];
        int[] count2 = new int[256];
        
        for (int i = 0; i < length; i++) {
            count1[value[i]]++;
            count2[other.value[i]]++;
        }
        
        for (int i = 0; i < 256; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
    
    // First non-repeating character
    public char firstNonRepeating() {
        int[] count = new int[256];
        for (int i = 0; i < length; i++) {
            count[value[i]]++;
        }
        
        for (int i = 0; i < length; i++) {
            if (count[value[i]] == 1) {
                return value[i];
            }
        }
        return '\0'; // Return null character if none found
    }
    
    @Override
    public String toString() {
        return new String(value);
    }
}