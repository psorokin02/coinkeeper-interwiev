package org.example.brace;

import javax.annotation.Nonnull;

/**
 * Координаты скобки описывающие ее положение в строке
 */
public class BracketCoordinates {

    /**
     * Тип скобки
     */
    @Nonnull
    private final BracketType bracketType;
    /**
     * Индекс открытия скобки
     */
    @Nonnull
    private final Integer openingBracketIndex;
    /**
     * Идекс закрытия скобки
     */
    @Nonnull
    private final Integer closeBracketIndex;

    public BracketCoordinates(
            @Nonnull BracketType bracketType,
            @Nonnull Integer openingBracketIndex,
            @Nonnull Integer closeBracketIndex
    ) {
        this.bracketType = bracketType;
        this.openingBracketIndex = openingBracketIndex;
        this.closeBracketIndex = closeBracketIndex;
    }

    /**
     * Создает новый объект билдера для {@link BracketCoordinates}
     */
    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    @Nonnull
    public BracketType getBracketType() {
        return bracketType;
    }

    @Nonnull
    public Integer getOpeningBracketIndex() {
        return openingBracketIndex;
    }

    @Nonnull
    public Integer getCloseBracketIndex() {
        return closeBracketIndex;
    }

    @Override
    public String toString() {
        return "BracketCoordinates{" +
                "bracketType=" + bracketType +
                ", openingBracketIndex=" + openingBracketIndex +
                ", closeBracketIndex=" + closeBracketIndex +
                '}';
    }

    /**
     * Билдер для {@link BracketCoordinates}
     */
    public static final class Builder {
        private BracketType bracketType;
        private Integer openingBracketIndex;
        private Integer closeBracketIndex;

        private Builder() {
        }

        public Builder withBracketType(@Nonnull BracketType bracketType) {
            this.bracketType = bracketType;
            return this;
        }

        public Builder withOpeningBracketIndex(@Nonnull Integer openingBracketIndex) {
            this.openingBracketIndex = openingBracketIndex;
            return this;
        }

        public Builder withCloseBracketIndex(@Nonnull Integer closeBracketIndex) {
            this.closeBracketIndex = closeBracketIndex;
            return this;
        }

        /**
         * Собрать объект
         */
        @Nonnull
        public BracketCoordinates build() {
            return new BracketCoordinates(bracketType, openingBracketIndex, closeBracketIndex);
        }
    }
}
