class MyString {
    private char[] value;
    private int length;
    
    // Constructors
    public MyString() {
        this.value = new char[0];
        this.length = 0;
    }
    
    public MyString(String str) {
        this.value = str.toCharArray();
        this.length = str.length();
    }
    
    public MyString(char[] chars) {
        this.value = chars.clone();
        this.length = chars.length;
    }
    
    // Length method
    public int length() {
        return length;
    }
    
    // Character at index
    public char charAt(int index) {
        if (index < 0 || index >= length) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return value[index];
    }
    
    // Substring
    public MyString substring(int beginIndex, int endIndex) {
        if (beginIndex < 0 || endIndex > length || beginIndex > endIndex) {
            throw new StringIndexOutOfBoundsException();
        }
        
        char[] newChars = new char[endIndex - beginIndex];
        System.arraycopy(value, beginIndex, newChars, 0, newChars.length);
        return new MyString(newChars);
    }
    
    // Concatenation
    public MyString concat(MyString str) {
        char[] newChars = new char[length + str.length];
        System.arraycopy(value, 0, newChars, 0, length);
        System.arraycopy(str.value, 0, newChars, length, str.length);
        return new MyString(newChars);
    }
    
    // Index of character
    public int indexOf(char ch) {
        for (int i = 0; i < length; i++) {
            if (value[i] == ch) {
                return i;
            }
        }
        return -1;
    }
    
    // Index of substring
    public int indexOf(MyString str) {
        if (str.length == 0) return 0;
        if (str.length > length) return -1;
        
        for (int i = 0; i <= length - str.length; i++) {
            boolean found = true;
            for (int j = 0; j < str.length; j++) {
                if (value[i + j] != str.value[j]) {
                    found = false;
                    break;
                }
            }
            if (found) return i;
        }
        return -1;
    }
    
    // Equals
    public boolean equals(MyString str) {
        if (str == null) return false;
        if (length != str.length) return false;
        
        for (int i = 0; i < length; i++) {
            if (value[i] != str.value[i]) {
                return false;
            }
        }
        return true;
    }
    
    // Compare to
    public int compareTo(MyString str) {
        int minLength = Math.min(length, str.length);
        
        for (int i = 0; i < minLength; i++) {
            if (value[i] != str.value[i]) {
                return value[i] - str.value[i];
            }
        }
        return length - str.length;
    }
    
    // To uppercase
    public MyString toUpperCase() {
        char[] newChars = new char[length];
        for (int i = 0; i < length; i++) {
            if (value[i] >= 'a' && value[i] <= 'z') {
                newChars[i] = (char)(value[i] - 32);
            } else {
                newChars[i] = value[i];
            }
        }
        return new MyString(newChars);
    }
    
    // To lowercase
    public MyString toLowerCase() {
        char[] newChars = new char[length];
        for (int i = 0; i < length; i++) {
            if (value[i] >= 'A' && value[i] <= 'Z') {
                newChars[i] = (char)(value[i] + 32);
            } else {
                newChars[i] = value[i];
            }
        }
        return new MyString(newChars);
    }
    
    // Trim whitespace
    public MyString trim() {
        int start = 0;
        int end = length - 1;
        
        while (start <= end && Character.isWhitespace(value[start])) {
            start++;
        }
        while (end >= start && Character.isWhitespace(value[end])) {
            end--;
        }
        
        if (start > end) {
            return new MyString();
        }
        
        char[] newChars = new char[end - start + 1];
        System.arraycopy(value, start, newChars, 0, newChars.length);
        return new MyString(newChars);
    }
    
    // Split
    public MyString[] split(char delimiter) {
        int count = 1;
        for (int i = 0; i < length; i++) {
            if (value[i] == delimiter) {
                count++;
            }
        }
        
        MyString[] result = new MyString[count];
        int start = 0;
        int index = 0;
        
        for (int i = 0; i < length; i++) {
            if (value[i] == delimiter) {
                char[] part = new char[i - start];
                System.arraycopy(value, start, part, 0, part.length);
                result[index++] = new MyString(part);
                start = i + 1;
            }
        }
        
        char[] lastPart = new char[length - start];
        System.arraycopy(value, start, lastPart, 0, lastPart.length);
        result[index] = new MyString(lastPart);
        
        return result;
    }
    
    // Replace character
    public MyString replace(char oldChar, char newChar) {
        char[] newChars = new char[length];
        for (int i = 0; i < length; i++) {
            newChars[i] = (value[i] == oldChar) ? newChar : value[i];
        }
        return new MyString(newChars);
    }
    
    // Check if empty
    public boolean isEmpty() {
        return length == 0;
    }
    
    // Check if starts with
    public boolean startsWith(MyString prefix) {
        if (prefix.length > length) return false;
        
        for (int i = 0; i < prefix.length; i++) {
            if (value[i] != prefix.value[i]) {
                return false;
            }
        }
        return true;
    }
    
    // Check if ends with
    public boolean endsWith(MyString suffix) {
        if (suffix.length > length) return false;
        
        int start = length - suffix.length;
        for (int i = 0; i < suffix.length; i++) {
            if (value[start + i] != suffix.value[i]) {
                return false;
            }
        }
        return true;
    }
    
    // Convert to String
    @Override
    public String toString() {
        return new String(value);
    }
    
    // Hash code
    @Override
    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = 31 * hash + value[i];
        }
        return hash;
    }
}