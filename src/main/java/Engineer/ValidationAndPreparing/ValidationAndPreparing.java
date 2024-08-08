package Engineer.ValidationAndPreparing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

/**
 * @author Efimov Artyom or Perryell
 * @version 1.0
 * Предназначен для подготовки и проверки валидности инфиксного выражения.
 * Вставляет упущенные знаки умножения там где это допустимо заменяет ',' на '.'.
 * Удаляет все пробелы и преобразует в нижний регистр.
 * Создайте обьект класса и получите результат вызвав {@link #isValid()}.
 */
@Setter
public class ValidationAndPreparing {
    private final String AFTER_DIGIT = "0123456789*+-/m%.^)";
    private final String MAYBE_FIRST = "0123456789(sctSCTQGLx-";
    private final String VALID_SYMBOLS = "0123456789().-+/*%xsctSCTQm^LG";
    private final String BINARY_OPERANDS = "-+*/m";
    private final String UNARY_OPERATORS = "sctSCTQlG";
    @Getter
    private boolean valid;
    @Getter
    private String infixExpression;

    public ValidationAndPreparing(@NotNull String infixExpression) {
        this.infixExpression = infixExpression;
        valid = true;
        if (infixExpression.isEmpty()) valid = false;
        else checkValid();
    }

    private void checkValid() {
        deleteAllSpaces();
        changeCommaToDot();
        infixToLowerCase();
        convertToShortOperators();
        checkInValidSymbols();
        insertMultiplyIfAbsence();
        if (valid) {
            checkDotSequence();
            if (valid) checkOrderOperandsAndOperators();
            if (this.valid) checkPercent();
            if (this.valid) onlyButtons();
        }

    }

    private boolean isSymbolInTheString(char ch, @NotNull String str) {
        boolean result = false;
        for (int i = 0; i < str.length(); ++i) {
            if (ch == str.charAt(i)) {
                result = true;
                break;
            }
        }

        return result;
    }

    private void deleteAllSpaces() {
        infixExpression = infixExpression.replaceAll(" ", "");
    }

    private void changeCommaToDot() {
        infixExpression = infixExpression.replaceAll(",", ".");
    }

    private void infixToLowerCase() {
        infixExpression = infixExpression.toLowerCase();
    }

    private void convertToShortOperators() {
        this.infixExpression = this.infixExpression.replaceAll("asin", "S");
        this.infixExpression = this.infixExpression.replaceAll("acos", "C");
        this.infixExpression = this.infixExpression.replaceAll("atan", "T");
        this.infixExpression = this.infixExpression.replaceAll("sqrt", "Q");
        this.infixExpression = this.infixExpression.replaceAll("ln", "L");
        this.infixExpression = this.infixExpression.replaceAll("log", "G");
        this.infixExpression = this.infixExpression.replaceAll("mod", "m");
        this.infixExpression = this.infixExpression.replaceAll("tan", "t");
        this.infixExpression = this.infixExpression.replaceAll("sin", "s");
        this.infixExpression = this.infixExpression.replaceAll("cos", "c");
    }

    private void checkInValidSymbols() {
        for (int i = 0; i < infixExpression.length(); ++i) {
            if (!isSymbolInTheString(infixExpression.charAt(i), VALID_SYMBOLS)) {
                valid = false;
                break;
            }
        }
    }

    private void insertMultiplyIfAbsence() {
        StringBuilder newInfixExpression = new StringBuilder();
        for (int i = 0; i < infixExpression.length() - 1; ++i) {
            if ((infixExpression.charAt(i) == ')' || Character.isDigit(infixExpression.charAt(i)) || infixExpression.charAt(i) == 'x') && infixExpression.charAt(i + 1) == '(') {
                newInfixExpression.append(infixExpression.charAt(i));
                newInfixExpression.append('*');
            } else if (infixExpression.charAt(i) == ')' && Character.isDigit(infixExpression.charAt(i + 1))) {
                newInfixExpression.append(infixExpression.charAt(i));
                newInfixExpression.append('*');
            } else if ((infixExpression.charAt(i) == ')' || Character.isDigit(infixExpression.charAt(i)) || infixExpression.charAt(i) == 'x') && isSymbolInTheString(infixExpression.charAt(i + 1), UNARY_OPERATORS)) {
                newInfixExpression.append(infixExpression.charAt(i));
                newInfixExpression.append('*');
            } else {
                newInfixExpression.append(infixExpression.charAt(i));
            }
        }
        newInfixExpression.append(infixExpression.charAt(infixExpression.length() - 1));
        infixExpression = newInfixExpression.toString();
    }

    private void checkOrderOperandsAndOperators() {
        int brackets = 0;
        for (int i = 0; i < infixExpression.length() && valid; ++i) {
            char ch = infixExpression.charAt(i);
            if (ch == '(') ++brackets;
            else if (ch == ')') --brackets;
            if (i == 0) checkFirst(ch);
            else if (i == infixExpression.length() - 1) checkEnd();
            else valid = checkSequence(i, infixExpression);
        }
        if (brackets != 0) this.valid = false;
    }

    private void checkFirst(char ch) {
        valid = isSymbolInTheString(ch, MAYBE_FIRST);
    }

    private boolean checkSequence(int i, @NotNull String expression) {
        boolean result = true;
        char current = expression.charAt(i);
        char previous = expression.charAt(i - 1);
        if (!Character.isDigit(previous) && previous != 'x') {
            if (isSymbolInTheString(current, BINARY_OPERANDS)) {
                result = checkIfBinaryOperator(current, previous);
            }
        } else if (!isSymbolInTheString(current, AFTER_DIGIT)) {
            result = false;
        }
        if (previous == '%' && Character.isDigit(current)) {
            result = false;
        }
        return result;
    }

    private boolean checkIfBinaryOperator(char current, char previous) {
        boolean result = true;
        if (current == '-') {
            if (previous != '(' && previous != ')' && !Character.isDigit(previous) && previous != 'x' && previous != '%') {
                result = false;
            }
        } else if (previous != ')' && !Character.isDigit(previous) && previous != 'x' && previous != '%') {
            result = false;
        }
        return result;
    }

    private void checkDotSequence() {
        Pattern dotsLine = Pattern.compile("\\.{2,}");
        Pattern moreOneDotInNum = Pattern.compile("[0-9]+\\.+[0-9]+\\.+");
        Pattern notDigitBefore = Pattern.compile("\\D\\.");
        Pattern notDigitAfter = Pattern.compile("\\.\\D");
        Matcher lineDotMatcher = dotsLine.matcher(infixExpression);
        Matcher moreOneDotInNumMatcher = moreOneDotInNum.matcher(infixExpression);
        Matcher notDigitBeforeMatcher = notDigitBefore.matcher(infixExpression);
        Matcher notDigitAfterMatcher = notDigitAfter.matcher(infixExpression);
        if (moreOneDotInNumMatcher.find() || lineDotMatcher.find() || notDigitBeforeMatcher.find() || notDigitAfterMatcher.find()) {
            valid = false;
        }

    }

    private void checkPercent() {
        Pattern invalidPercentPattern = Pattern.compile("[^)\\d]%");
        Matcher invalidPercentMatcher = invalidPercentPattern.matcher(infixExpression);
        if (invalidPercentMatcher.find()) {
            valid = false;
        }

    }

    private void checkEnd() {
        if (this.infixExpression.charAt(infixExpression.length() - 1) != ')' &&
                !Character.isDigit(infixExpression.charAt(infixExpression.length() - 1)) &&
                infixExpression.charAt(infixExpression.length() - 1) != '%' &&
                infixExpression.charAt(infixExpression.length() - 1) != 'x') {
            valid = false;
        }

    }

    private void onlyButtons() {
        Pattern onlyButtonsPattern = Pattern.compile("\\(\\)");
        Matcher onlyButtonsMatcher = onlyButtonsPattern.matcher(infixExpression);
        if (onlyButtonsMatcher.find()) {
            valid = false;
        }
    }
}
