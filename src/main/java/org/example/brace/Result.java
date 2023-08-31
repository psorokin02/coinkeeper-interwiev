package org.example.brace;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Результат, поддерживаемый возможность передачи ошибки
 * @param <ResultT> тип результата
 * @param <ErrorT> тип ошибки
 */
public class Result<ResultT, ErrorT> {

    private final ResultT result;
    private final ErrorT error;

    public Result(ResultT result, ErrorT error) {
        if (result == null && error == null) {
            throw new IllegalArgumentException("Result and error are null");
        }
        this.result = result;
        this.error = error;
    }

    public boolean isSuccess() {
        return error != null;
    }

    public boolean isError() {
        return error == null;
    }

    public static <ResultT, ErrorT> Result<ResultT, ErrorT> success(ResultT result) {
        return new Result<>(result, null);
    }

    public static <ResultT, ErrorT> Result<ResultT, ErrorT> fail(ErrorT error) {
        return new Result<>(null, error);
    }

    public ResultT getResultOrThrow() {
        return requireNonNull(result, "result");
    }

    public ErrorT getErrorOrThrow() {
        return requireNonNull(error, "error");
    }
}
