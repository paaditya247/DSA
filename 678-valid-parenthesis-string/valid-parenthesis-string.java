class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                minOpen++;
                maxOpen++;
            } 
            else if (c == ')') {
                minOpen--;
                maxOpen--;
            } 
            else { // '*'
                minOpen--;  // Treat '*' as ')'
                maxOpen++;  // Treat '*' as '('
            }

            // Even the maximum possible '(' is negative
            if (maxOpen < 0) {
                return false;
            }

            // We cannot have negative unmatched '('
            minOpen = Math.max(minOpen, 0);
        }

        // There must be a way to have exactly 0 unmatched '('
        return minOpen == 0;
    }
}
