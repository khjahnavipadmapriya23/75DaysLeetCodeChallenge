import java.util.*;

class Solution {

    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();

        int num = 0;

        for (char ch : s.toCharArray()) {

            // Build multi-digit number
            if (Character.isDigit(ch)) {

                num = num * 10 + (ch - '0');
            }

            // Start new bracket level
            else if (ch == '[') {

                countStack.push(num);
                stringStack.push(current);

                num = 0;
                current = new StringBuilder();
            }

            // End bracket level
            else if (ch == ']') {

                int repeat = countStack.pop();

                StringBuilder previous = stringStack.pop();

                for (int i = 0; i < repeat; i++) {

                    previous.append(current);
                }

                current = previous;
            }

            // Normal character
            else {

                current.append(ch);
            }
        }

        return current.toString();
    }
}