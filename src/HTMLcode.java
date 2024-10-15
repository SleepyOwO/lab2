import java.util.regex.*;

public class HTMLcode {

    /// строка для проверки
    private String _hexCode;

    ///результат проверки
    private boolean _checkResult;

    ///регулярное выражение
    private final String _reg ="^#([a-fA-F0-9]{6})";

    private static HTMLcode[] _array;
    private static String[] _resArray;

    /**
     * конструктор по умолчанию для класса HTMLcode
     */
    HTMLcode(){
        _hexCode = "";
        _checkResult = false;
    }

    /**
     * Конструктор класса HTMLcode
     * @param code строка для проверки
     */
    HTMLcode(String code){
        _hexCode = code;
    }

    /**
     * конструктор класса HTMLcode
     * определяет значение полей _hexCode и _reg
     * @param code массив строк для проверки
     */
    HTMLcode(String[] code) {
        if (code[0].isEmpty()){
            throw new RuntimeException();
        }
        _array = new HTMLcode[code.length];
        _resArray = new String[code.length];
        for (int i = 0; i < code.length; i++){
            _array[i] = new HTMLcode(code[i]);
        }
    }

    /**
     * проверяет строку на соответствие регулярному выражению
     */
    public void Check(){
        for (var i : _array){
            i._checkResult = Pattern.matches(_reg, i._hexCode);
        }
    }

    /**
     * возвращает результат проверки строки
     * @return строка, результат проверки.
     */

    public String get_checkResult(){
        String res = "Строка: " + _hexCode + ", результат: " + _checkResult;
        return res;
    }

    /**
     * возвращает результат проверки всех полученных строк
     */
    public String[] get_all_results(){
        for (int i = 0; i < _array.length; i++){
            _resArray[i] = _array[i].get_checkResult();
        }
        return _resArray;
    }

}
