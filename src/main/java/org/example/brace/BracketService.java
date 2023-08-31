package org.example.brace;

import javax.annotation.Nonnull;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Сервис для поиска всех скобок в строковой последовательности
 */
public class BracketService {

    /**
     * Осуществить поиск всех позиций скобок по строке, состоящей из скобок
     * @param stringWithBrackets строка из скобок
     * @return результат поиска - все скобки или ошибка
     */
    public Result<List<BracketCoordinates>, BracketSearchError> searchBrackets(@Nonnull String stringWithBrackets) {
        Deque<Character> charsStack = new ArrayDeque<>();
        Deque<Integer> indexesStack = new ArrayDeque<>();
        List<BracketCoordinates> bracketsResult = new ArrayList<>();

        for (int i = 0; i < stringWithBrackets.length(); ++i) {
            var currentChar = stringWithBrackets.charAt(i);

            if (BracketType.isOpeningBracket(currentChar)) {
                charsStack.push(currentChar);
                indexesStack.push(i);
                continue;
            }

            if (charsStack.isEmpty()) {
                return Result.fail(BracketSearchError.SEQUENCE_INVALID);
            }
            var charFromStack = charsStack.pop();

            var currentBracketType = BracketType.findBracket(currentChar);
            var bracketTypeFromStack = BracketType.findBracket(charFromStack);

            if (currentBracketType.isEmpty() || bracketTypeFromStack.isEmpty()) {
                return Result.fail(BracketSearchError.NOT_BRACKET_FOUND);
            }
            if (!currentBracketType.orElseThrow().equals(bracketTypeFromStack.orElseThrow())) {
                return Result.fail(BracketSearchError.SEQUENCE_INVALID);
            }

            bracketsResult.add(BracketCoordinates
                    .builder()
                            .withBracketType(currentBracketType.orElseThrow())
                            .withOpeningBracketIndex(indexesStack.pop())
                            .withCloseBracketIndex(i)
                    .build());
        }

        if (!charsStack.isEmpty()) {
            return Result.fail(BracketSearchError.SEQUENCE_INVALID);
        }

        return Result.success(bracketsResult);
    }

}
