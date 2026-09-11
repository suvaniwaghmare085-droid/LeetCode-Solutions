class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        backtrack(result, "", 0, 0, n);

        return result;
    }

    public void backtrack(List<String> result,
                           String current,
                           int open,
                           int close,
                           int n) {

        // If we have used all brackets
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add an opening bracket
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // Add a closing bracket
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}