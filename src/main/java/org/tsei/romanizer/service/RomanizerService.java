package org.tsei.romanizer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Service
public class RomanizerService {

    private final Map<String, String> alphabetToShow = new LinkedHashMap<>() {{
        put("А", "A");
        put("а", "a");
        put("Б", "B");
        put("б", "b");
        put("В", "W");
        put("в", "w");
        put("Г", "G");
        put("г", "g");
        put("Гъ", "Г");
        put("гъ", "г");
        put("Д", "D");
        put("д", "d");
        put("Дж", "Ǥ");
        put("дж", "ǥ");
        put("Дз", "Ʒ");
        put("дз", "ʒ");
        put("Е", "E");
        put("е", "e");
        put("Ё", "Ø");
        put("ё", "ø");
        put("Ж", "J");
        put("ж", "j");
        put("Жъ", "Ⲍ");
        put("жъ", "ⲍ");
        put("Жь", "Ɩ");
        put("жь", "ɩ");
        put("З", "Z");
        put("з", "z");
        put("И", "I");
        put("и", "i");
        put("Й", "Y");
        put("й", "y");
        put("К", "K");
        put("к", "k");
        put("Къ", "Q");
        put("къ", "q");
        put("Кхъ", "Q̃");
        put("кхъ", "q̃");
        put("К1", "Ⱪ");
        put("к1", "ⱪ");
        put("Л", "L");
        put("л", "l");
        put("Лъ", "Ł");
        put("лъ", "ł");
        put("Л1", "Ḷ");
        put("л1", "ḷ");
        put("М", "M");
        put("м", "m");
        put("Н", "N");
        put("н", "n");
        put("О", "O");
        put("о", "o");
        put("П", "P");
        put("п", "p");
        put("П1", "Ᵽ");
        put("п1", "ᵽ");
        put("Р", "R");
        put("р", "r");
        put("С", "S");
        put("с", "s");
        put("Т", "T");
        put("т", "t");
        put("Т1", "Ţ");
        put("т1", "ţ");
        put("У", "V");
        put("у", "v");
        put("Ф", "F");
        put("ф", "f");
        put("Ф1", "Ⅎ");
        put("ф1", "ⅎ");
        put("Х", "X");
        put("х", "x");
        put("Хъ", "Ҳ");
        put("хъ", "ҳ");
        put("Хь", "Ẍ");
        put("хь", "ẍ");
        put("Ц", "C");
        put("ц", "c");
        put("Ц1", "Ç");
        put("ц1", "ç");
        put("Ч", "H");
        put("ч", "h");
        put("Чъ", "Ħ");
        put("чъ", "ħ");
        put("Ч1", "Ӈ");
        put("ч1", "ꜧ");
        put("Ш", "Ƨ");
        put("ш", "ƨ");
        put("Шъ", "Š");
        put("шъ", "š");
        put("Ш1", "Ş");
        put("ш1", "ş");
        put("Щ", "Ʃ");
        put("щ", "ʃ");
        put("Щ1", "ß");
        put("щ1", "ß");
        put("Ы", "Ʌ");
        put("ы", "ʌ");
        put("Э", "Ǝ");
        put("э", "ǝ");
        put("Ю", "U");
        put("ю", "u");
        put("Я", "Â");
        put("я", "â");
        put("1", "ƪ");
        put("l", "ƪ");
        put("Ъ", "");
        put("ъ", "");
        put("Ь", "");
        put("ь", "");
    }};

    private final Map<String, String> alphabet = new HashMap<>() {{
        put("а", "a");
        put("А", "A");
        put("б", "b");
        put("Б", "B");
        put("в", "w");
        put("В", "W");
        put("г", "g");
        put("Г", "G");

        put("гъ", "г");
        put("Гъ", "Г");
        put("гЪ", "г");
        put("ГЪ", "Г");

        put("д", "d");
        put("Д", "D");

        put("дж", "ǥ");
        put("Дж", "Ǥ");
        put("дЖ", "ǥ");
        put("ДЖ", "Ǥ");

        put("дз", "ʒ");
        put("Дз", "Ʒ");
        put("дЗ", "ʒ");
        put("ДЗ", "Ʒ");

        put("е", "e");
        put("Е", "E");
        put("ё", "ø");
        put("Ё", "Ø");
        put("ж", "j");
        put("Ж", "J");

        put("жъ", "ⲍ");
        put("Жъ", "Ⲍ");
        put("жЪ", "ⲍ");
        put("ЖЪ", "Ⲍ");

        put("жь", "ɩ");
        put("Жь", "Ɩ");
        put("жЬ", "ɩ");
        put("ЖЬ", "Ɩ");

        put("з", "z");
        put("З", "Z");
        put("и", "i");
        put("И", "I");
        put("й", "y");
        put("Й", "Y");
        put("к", "k");
        put("К", "K");

        put("къ", "q");
        put("Къ", "Q");
        put("кЪ", "q");
        put("КЪ", "Q");

        put("кхъ", "q̃");
        put("Кхъ", "Q̃");
        put("кХъ", "q̃");
        put("кхЪ", "q̃");
        put("КХъ", "Q̃");
        put("кХЪ", "q̃");
        put("КХЪ", "Q̃");

        put("кl", "ⱪ");
        put("Кl", "Ⱪ");
        put("КL", "Ⱪ");
        put("к1", "ⱪ");
        put("К1", "Ⱪ");
        put("к|", "ⱪ");
        put("К|", "Ⱪ");
        put("к'", "ⱪ");
        put("К'", "Ⱪ");
        put("к’", "ⱪ");
        put("К’", "Ⱪ");
        put("кӀ", "ⱪ");
        put("КӀ", "Ⱪ");
        put("кI", "ⱪ");
        put("КI", "Ⱪ");
        put("кi", "ⱪ");
        put("Кi", "Ⱪ");

        put("л", "l");
        put("Л", "L");

        put("лъ", "ł");
        put("Лъ", "Ł");
        put("лЪ", "ł");
        put("ЛЪ", "Ł");

        put("лl", "ḷ");
        put("Лl", "Ḷ");
        put("ЛL", "Ḷ");
        put("л1", "ḷ");
        put("Л1", "Ḷ");
        put("л|", "ḷ");
        put("Л|", "Ḷ");
        put("л'", "ḷ");
        put("Л'", "Ḷ");
        put("л’", "ḷ");
        put("Л’", "Ḷ");
        put("лӀ", "ḷ");
        put("ЛӀ", "Ḷ");
        put("лI", "ḷ");
        put("ЛI", "Ḷ");
        put("лi", "ḷ");
        put("Лi", "Ḷ");

        put("м", "m");
        put("М", "M");
        put("н", "n");
        put("Н", "N");
        put("о", "o");
        put("О", "O");
        put("п", "p");
        put("П", "P");

        put("пl", "ᵽ");
        put("Пl", "Ᵽ");
        put("ПL", "Ᵽ");
        put("п1", "ᵽ");
        put("П1", "Ᵽ");
        put("п|", "ᵽ");
        put("П|", "Ᵽ");
        put("п'", "ᵽ");
        put("П'", "Ᵽ");
        put("п’", "ᵽ");
        put("П’", "Ᵽ");
        put("пӀ", "ᵽ");
        put("ПӀ", "Ᵽ");
        put("пI", "ᵽ");
        put("ПI", "Ᵽ");
        put("пi", "ᵽ");
        put("Пi", "Ᵽ");

        put("р", "r");
        put("Р", "R");
        put("с", "s");
        put("С", "S");
        put("т", "t");
        put("Т", "T");

        put("тl", "ţ");
        put("Тl", "Ţ");
        put("ТL", "Ţ");
        put("т1", "ţ");
        put("Т1", "Ţ");
        put("т|", "ţ");
        put("Т|", "Ţ");
        put("т'", "ţ");
        put("Т'", "Ţ");
        put("т’", "ţ");
        put("Т’", "Ţ");
        put("тӀ", "ţ");
        put("ТӀ", "Ţ");
        put("тI", "ţ");
        put("ТI", "Ţ");
        put("тi", "ţ");
        put("Тi", "Ţ");

        put("у", "v");
        put("У", "V");
        put("ф", "f");
        put("Ф", "F");

        put("фl", "ⅎ");
        put("Фl", "Ⅎ");
        put("ФL", "Ⅎ");
        put("ф1", "ⅎ");
        put("Ф1", "Ⅎ");
        put("ф|", "ⅎ");
        put("Ф|", "Ⅎ");
        put("ф'", "ⅎ");
        put("Ф'", "Ⅎ");
        put("ф’", "ⅎ");
        put("Ф’", "Ⅎ");
        put("фӀ", "ⅎ");
        put("ФӀ", "Ⅎ");
        put("фI", "ⅎ");
        put("ФI", "Ⅎ");
        put("фi", "ⅎ");
        put("Фi", "Ⅎ");

        put("х", "x");
        put("Х", "X");

        put("хъ", "ҳ");
        put("Хъ", "Ҳ");
        put("хЪ", "ҳ");
        put("ХЪ", "Ҳ");

        put("хь", "ẍ");
        put("Хь", "Ẍ");
        put("хЬ", "ẍ");
        put("ХЬ", "Ẍ");

        put("ц", "c");
        put("Ц", "C");

        put("цl", "ç");
        put("Цl", "Ç");
        put("ЦL", "Ç");
        put("ц1", "ç");
        put("Ц1", "Ç");
        put("ц|", "ç");
        put("Ц|", "Ç");
        put("ц'", "ç");
        put("Ц'", "Ç");
        put("ц’", "ç");
        put("Ц’", "Ç");
        put("цӀ", "ç");
        put("ЦӀ", "Ç");
        put("цI", "ç");
        put("ЦI", "Ç");
        put("цi", "ç");
        put("Цi", "Ç");

        put("ч", "H");
        put("Ч", "h");

        put("чъ", "ħ");
        put("Чъ", "Ħ");
        put("чЪ", "ħ");
        put("ЧЪ", "Ħ");

        put("чl", "ꜧ");
        put("Чl", "Ӈ");
        put("ЧL", "Ӈ");
        put("ч1", "ꜧ");
        put("Ч1", "Ӈ");
        put("ч|", "ꜧ");
        put("Ч|", "Ӈ");
        put("ч'", "ꜧ");
        put("Ч'", "Ӈ");
        put("ч’", "ꜧ");
        put("Ч’", "Ӈ");
        put("чӀ", "ꜧ");
        put("ЧӀ", "Ӈ");
        put("чI", "ꜧ");
        put("ЧI", "Ӈ");
        put("чi", "ꜧ");
        put("Чi", "Ӈ");

        put("ш", "ƨ");
        put("Ш", "Ƨ");

        put("шъ", "š");
        put("Шъ", "Š");
        put("шЪ", "š");
        put("ШЪ", "Š");

        put("шl", "ş");
        put("Шl", "Ş");
        put("ШL", "Ş");
        put("ш1", "ş");
        put("Ш1", "Ş");
        put("ш|", "ş");
        put("Ш|", "Ş");
        put("ш'", "ş");
        put("Ш'", "Ş");
        put("ш’", "ş");
        put("Ш’", "Ş");
        put("шӀ", "ş");
        put("ШӀ", "Ş");
        put("шI", "ş");
        put("ШI", "Ş");
        put("шi", "ş");
        put("Шi", "Ş");

        put("щ", "ʃ");
        put("Щ", "Ʃ");

        put("щl", "ß");
        put("Щl", "ß");
        put("ЩL", "ß");
        put("щ1", "ß");
        put("Щ1", "ß");
        put("щ|", "ß");
        put("Щ|", "ß");
        put("щ'", "ß");
        put("Щ'", "ß");
        put("щ’", "ß");
        put("Щ’", "ß");
        put("щӀ", "ß");
        put("ЩӀ", "ß");
        put("щI", "ß");
        put("ЩI", "ß");
        put("щi", "ß");
        put("Щi", "ß");

        put("ы", "ʌ");
        put("Ы", "Ʌ");
        put("э", "ǝ");
        put("Э", "Ǝ");
        put("ю", "u");
        put("Ю", "U");
        put("я", "â");
        put("Я", "Â");

        put("l", "ƪ");
        put("1", "ƪ");
        put("|", "ƪ");
        put("Ӏ", "ƪ");
        put("I", "ƪ");
        put("i", "ƪ");

        put("ъ", "");
        put("ь", "");
        put("Ъ", "");
        put("Ь", "");
    }};

    private Map<String, String> weirdLetter = new HashMap<>() {{
        put("l", "ƪ");
        put("1", "ƪ");
        put("|", "ƪ");
        put("Ӏ", "ƪ");
        put("I", "ƪ");
        put("i", "ƪ");
    }};

    public String printAlphabet() {
        int count = 0;
        StringBuilder result = new StringBuilder();
        ArrayList<Map.Entry<String, String>> entries = new ArrayList<>(alphabetToShow.entrySet());
        for (int i = 0; i < entries.size() - 1; i+=2) {
            result.append(entries.get(i).getKey()).append(" ").append(entries.get(i + 1).getKey()).append(": ")
                    .append(entries.get(i).getValue()).append(" ").append(entries.get(i + 1).getValue());
            result.append("\n");
        }
        return result.toString();
    }

    public String romanize(String cyrillicVersion) {
        StringBuilder romanizedVersion = new StringBuilder();
        AtomicBoolean errorLogged = new AtomicBoolean(false);
        for (int index = 0; index < cyrillicVersion.length(); index++) {
            if (cyrillicOrStopLetter(cyrillicVersion, index)) {
                int endOfCyrillicLetterIndex = getEndOfCyrillicLetterIndex(cyrillicVersion, index, getEndOfWordIndex(cyrillicVersion, index));
                index = romanizeLetterAndAdd(cyrillicVersion, index, endOfCyrillicLetterIndex, romanizedVersion, errorLogged);
            } else {
                romanizedVersion.append(cyrillicVersion.charAt(index));
            }
        }
        return romanizedVersion.toString();
    }

    private boolean cyrillicOrStopLetter(String cyrillicVersion, int index) {
        return Character.UnicodeBlock.of(cyrillicVersion.charAt(index)).equals(Character.UnicodeBlock.CYRILLIC)
                || weirdLetter.containsKey(String.valueOf(cyrillicVersion.charAt(index)));
    }

    private int getEndOfWordIndex(String cyrillicVersion, int index) {
        int endOfWordIndex = index;
        while (cyrillicOrStopLetter(cyrillicVersion, index) && endOfWordIndex < cyrillicVersion.length()) {
            endOfWordIndex++;
        }
        return endOfWordIndex;
    }

    private int getEndOfCyrillicLetterIndex(String cyrillicVersion, int index, int endOfWordIndex) {
        while (!alphabet.containsKey(cyrillicVersion.substring(index, endOfWordIndex)) && endOfWordIndex > index) {
            endOfWordIndex--;
        }
        return endOfWordIndex;
    }

    private int romanizeLetterAndAdd(String cyrillicVersion, int index, int endOfCyrillicLetterIndex, StringBuilder romanizedVersion, AtomicBoolean errorLogged) {
        if (endOfCyrillicLetterIndex != index) {
            romanizedVersion.append(alphabet.get(cyrillicVersion.substring(index, endOfCyrillicLetterIndex)));
            index = endOfCyrillicLetterIndex - 1;
        } else {
            romanizedVersion.append(cyrillicVersion.charAt(index));
            if (!errorLogged.get()) {
                log.error("Error converting text: " + cyrillicVersion);
                errorLogged.set(true);
            }
        }
        return index;
    }

    public String printAllAlphabet() {
        StringBuilder result = new StringBuilder();
        alphabet.forEach((k, v) -> {
            result.append(k + ": " + v + "; ");
        });
        return result.toString();
    }

    public Map<String, String> getAlphabet() {
        return alphabet;
    }

    public Map<String, String> getAlphabetToShow() {
        return alphabetToShow;
    }
}
