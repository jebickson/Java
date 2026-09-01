class MyStringBuffer {
    private char[] value;
    private int length;
    private int capacity;
    
    public MyStringBuffer() {
        this.capacity = 16;
        this.value = new char[capacity];
        this.length = 0;
    }
    
    public MyStringBuffer(String str) {
        this.capacity = str.length() + 16;
        this.value = new char[capacity];
        System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
        this.length = str.length();
    }
    
    // Ensure capacity
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > capacity) {
            int newCapacity = Math.max(capacity * 2, minCapacity);
            char[] newValue = new char[newCapacity];
            System.arraycopy(value, 0, newValue, 0, length);
            value = newValue;
            capacity = newCapacity;
        }
    }
    
    // Append
    public MyStringBuffer append(String str) {
        char[] chars = str.toCharArray();
        ensureCapacity(length + chars.length);
        System.arraycopy(chars, 0, value, length, chars.length);
        length += chars.length;
        return this;
    }
    
    public MyStringBuffer append(char ch) {
        ensureCapacity(length + 1);
        value[length++] = ch;
        return this;
    }
    
    public MyStringBuffer append(int num) {
        return append(String.valueOf(num));
    }
    
    // Insert
    public MyStringBuffer insert(int index, String str) {
        if (index < 0 || index > length) {
            throw new StringIndexOutOfBoundsException(index);
        }
        
        char[] chars = str.toCharArray();
        ensureCapacity(length + chars.length);
        
        // Shift characters to the right
        System.arraycopy(value, index, value, index + chars.length, length - index);
        System.arraycopy(chars, 0, value, index, chars.length);
        length += chars.length;
        return this;
    }
    
    // Delete
    public MyStringBuffer delete(int start, int end) {
        if (start < 0 || end > length || start > end) {
            throw new StringIndexOutOfBoundsException();
        }
        
        int count = end - start;
        System.arraycopy(value, end, value, start, length - end);
        length -= count;
        return this;
    }
    
    // Delete character at index
    public MyStringBuffer deleteCharAt(int index) {
        if (index < 0 || index >= length) {
            throw new StringIndexOutOfBoundsException(index);
        }
        
        System.arraycopy(value, index + 1, value, index, length - index - 1);
        length--;
        return this;
    }
    
    // Replace
    public MyStringBuffer replace(int start, int end, String str) {
        delete(start, end);
        insert(start, str);
        return this;
    }
    
    // Reverse
    public MyStringBuffer reverse() {
        for (int i = 0; i < length / 2; i++) {
            char temp = value[i];
            value[i] = value[length - 1 - i];
            value[length - 1 - i] = temp;
        }
        return this;
    }
    
    // Get capacity
    public int capacity() {
        return capacity;
    }
    
    // Get length
    public int length() {
        return length;
    }
    
    // Set length
    public void setLength(int newLength) {
        if (newLength < 0) {
            throw new StringIndexOutOfBoundsException(newLength);
        }
        
        if (newLength > capacity) {
            ensureCapacity(newLength);
        }
        
        if (newLength > length) {
            // Fill with null characters
            for (int i = length; i < newLength; i++) {
                value[i] = '\0';
            }
        }
        length = newLength;
    }
    
    // Char at
    public char charAt(int index) {
        if (index < 0 || index >= length) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return value[index];
    }
    
    // Set char at
    public void setCharAt(int index, char ch) {
        if (index < 0 || index >= length) {
            throw new StringIndexOutOfBoundsException(index);
        }
        value[index] = ch;
    }
    
    // Substring
    public String substring(int start, int end) {
        if (start < 0 || end > length || start > end) {
            throw new StringIndexOutOfBoundsException();
        }
        return new String(value, start, end - start);
    }
    
    @Override
    public String toString() {
        return new String(value, 0, length);
    }
}