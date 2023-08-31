package org.example.brace;

import javax.annotation.Nonnull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 * Поддерживаемые типы скобок
 */
public enum BracketType {

    SQUARE_BRACKET("squareBracket", '[', ']'),
    ROUND_BRACKET("roundBracket", '(', ')'),
    CURLY_BRACKET("curlyBracket", '{', '}');

    private final String name;
    /**
     * Открывающий симол скобки
     */
    private final Character openingChar;
    /**
     * Закрывающий символ скобки
     */
    private final Character closingChar;

    /**
     * Все открывающие скобки
     */
    private static final List<Character> OPENING_BRACKETS = new ArrayList<>();
    /**
     * Все закрывающие скобки
     */
    private static final List<Character> CLOSING_BRACKETS = new ArrayList<>();

    static {
        Arrays.stream(BracketType.values()).forEach(it -> {
            OPENING_BRACKETS.add(it.openingChar);
            CLOSING_BRACKETS.add(it.closingChar);
        });
    }


    BracketType(
            @Nonnull String name,
            @Nonnull Character openingChar,
            @Nonnull Character closingChar
    ) {
        this.name = requireNonNull(name, "name");
        this.openingChar = requireNonNull(openingChar, "openingChar");
        this.closingChar = requireNonNull(closingChar, "closingChar");
    }

    @Nonnull
    public static Optional<BracketType> findBracket(@Nonnull Character character) {
        return Arrays.stream(BracketType.values()).
                filter(it -> it.closingChar.equals(character) || it.openingChar.equals(character))
                .findFirst();
    }

    /**
     * Проверяет является ли символ скобкой
     * @return
     */
    public static boolean IsBracket(@Nonnull Character character) {
        return isClosingBracket(character) || isOpeningBracket(character);
    }

    public static boolean isOpeningBracket(@Nonnull Character character) {
        return OPENING_BRACKETS.contains(character);
    }

    public static boolean isClosingBracket(@Nonnull Character character) {
        return CLOSING_BRACKETS.contains(character);
    }
}
