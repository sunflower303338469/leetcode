package jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanmao on 2020/9/2.
 */
public class jianzhi20 {

    enum State {
        INITIAL,
        INT_SIGN,
        INTEGER,
        POINT,
        POINT_WITHOUT_INT,
        FRACTION,
        EXP,
        EXP_SIGN,
        EXP_NUMBER,
        END,
    }

    enum CharType {
        NUMBER,
        EXP,
        POINT,
        SIGN,
        SPACE,
        ILLEGAL,
    }

    private static Map<State, Map<CharType, State>> moveMap = new HashMap<>();

    static {
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.SPACE, State.INITIAL);
            put(CharType.NUMBER, State.INTEGER);
            put(CharType.POINT, State.POINT_WITHOUT_INT);
            put(CharType.SIGN, State.INT_SIGN);
        }};
        moveMap.put(State.INITIAL, initialMap);
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.INTEGER);
            put(CharType.POINT, State.POINT_WITHOUT_INT);
        }};
        moveMap.put(State.INT_SIGN, intSignMap);
        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.INTEGER);
            put(CharType.POINT, State.POINT);
            put(CharType.EXP, State.EXP);
            put(CharType.SPACE, State.END);
        }};
        moveMap.put(State.INTEGER, integerMap);
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.FRACTION);
            put(CharType.EXP, State.EXP);
            put(CharType.SPACE, State.END);
        }};
        moveMap.put(State.POINT, pointMap);
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.FRACTION);
        }};
        moveMap.put(State.POINT_WITHOUT_INT, pointWithoutIntMap);
        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.FRACTION);
            put(CharType.SPACE, State.END);
            put(CharType.EXP, State.EXP);
        }};
        moveMap.put(State.FRACTION, fractionMap);
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.EXP_NUMBER);
            put(CharType.SIGN, State.EXP_SIGN);
        }};
        moveMap.put(State.EXP, expMap);
        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.EXP_NUMBER);
        }};
        moveMap.put(State.EXP_SIGN, expSignMap);
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.EXP_NUMBER);
            put(CharType.SPACE, State.END);
        }};
        moveMap.put(State.EXP_NUMBER, expNumberMap);
        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            put(CharType.SPACE, State.END);
        }};
        moveMap.put(State.END, endMap);
    }


    public boolean isNumber(String s) {
        State state = State.INITIAL;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            CharType charType = toCharType(c);
            if (!moveMap.get(state).containsKey(charType)) {
                return false;
            }
            state = moveMap.get(state).get(charType);
        }
        return state == State.INTEGER || state == State.POINT || state == State.FRACTION || state == State.EXP_NUMBER || state == State.END;
    }

    private CharType toCharType(char c) {
        if (c >= '0' && c <= '9') {
            return CharType.NUMBER;
        } else if (c == 'e' || c == 'E') {
            return CharType.EXP;
        } else if (c == '.') {
            return CharType.POINT;
        } else if (c == '+' || c == '-') {
            return CharType.SIGN;
        } else if (c == ' ') {
            return CharType.SPACE;
        }
        return CharType.ILLEGAL;

    }
}
