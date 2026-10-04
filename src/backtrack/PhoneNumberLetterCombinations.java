package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneNumberLetterCombinations {

    Map<Character, String> digitToLetters = Map.ofEntries(
            Map.entry('0', ""),
            Map.entry('1', ""),
            Map.entry('2', "abc"),
            Map.entry('3', "def"),
            Map.entry('4', "ghi"),
            Map.entry('5', "jkl"),
            Map.entry('6', "mno"),
            Map.entry('7', "pqrs"),
            Map.entry('8', "tuv"),
            Map.entry('9', "wxyz")
    );

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>(50);
        backtrack(digits,0, new StringBuilder(), combinations);
        return combinations;
    }

    private void backtrack(String digits, int currentPos, StringBuilder current, List<String> combinations) {
        if (currentPos == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        String letters = digitToLetters.get(digits.charAt(currentPos));
        for(char c : letters.toCharArray()) {
            current.append(c);
            backtrack(digits, currentPos + 1, current, combinations);
            current.deleteCharAt(current.length() - 1);
        }
    }

}
