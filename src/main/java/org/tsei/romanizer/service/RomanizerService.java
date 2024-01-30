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
        put("Ё", "Yo");
        put("ё", "yo");
        put("Ж", "J");
        put("ж", "j");
        put("Жъ", "Ⲍ");
        put("жъ", "ⲍ");
        put("Жь", "Ե");
        put("жь", "ե");
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
        put("Ф1", "ᆿ");
        put("ф1", "\uD806\uDEDA");
        put("Х", "X");
        put("х", "x");
        put("Хъ", "Ҳ");
        put("хъ", "ҳ");
        put("Хь", "Ḩ");
        put("хь", "ḩ");
        put("Ц", "C");
        put("ц", "c");
        put("Ц1", "Ç");
        put("ц1", "ç");
        put("Ч", "Ƌ");
        put("ч", "ƌ");
        put("Чъ", "Ɖ");
        put("чъ", "ɖ");
        put("Ч1", "Ḍ");
        put("ч1", "ḍ");
        put("Ш", "Ħ");
        put("ш", "ħ");
        put("Шъ", "Š");
        put("шъ", "š");
        put("Ш1", "Ӈ");
        put("ш1", "ꜧ");
        put("Щ", "Ʃ");
        put("щ", "ʃ");
        put("Щ1", "Ṣ");
        put("щ1", "ṣ");
        put("Ы", "Ǝ");
        put("ы", "ǝ");
        put("Э", "Э");
        put("э", "э");
        put("Ю", "Yu");
        put("ю", "yu");
        put("Я", "Ya");
        put("я", "ya");
        put("1", "h");
        put("Ъ", "");
        put("Ь", "");
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
        put("ё", "yo");
        put("Ё", "Yo");
        put("ж", "j");
        put("Ж", "J");

        put("жъ", "ⲍ");
        put("Жъ", "Ⲍ");
        put("жЪ", "ⲍ");
        put("ЖЪ", "Ⲍ");

        put("жь", "ե");
        put("Жь", "Ե");
        put("жЬ", "ե");
        put("ЖЬ", "Ե");

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

        put("фl", "\uD806\uDEDA");
        put("Фl", "ᆿ");
        put("ФL", "ᆿ");
        put("ф1", "\uD806\uDEDA");
        put("Ф1", "ᆿ");
        put("ф|", "\uD806\uDEDA");
        put("Ф|", "ᆿ");
        put("ф'", "\uD806\uDEDA");
        put("Ф'", "ᆿ");
        put("ф’", "\uD806\uDEDA");
        put("Ф’", "ᆿ");
        put("фӀ", "\uD806\uDEDA");
        put("ФӀ", "ᆿ");
        put("фI", "\uD806\uDEDA");
        put("ФI", "ᆿ");
        put("фi", "\uD806\uDEDA");
        put("Фi", "ᆿ");

        put("х", "x");
        put("Х", "X");

        put("хъ", "ҳ");
        put("Хъ", "Ҳ");
        put("хЪ", "ҳ");
        put("ХЪ", "Ҳ");

        put("хь", "ḩ");
        put("Хь", "Ḩ");
        put("хЬ", "ḩ");
        put("ХЬ", "Ḩ");

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

        put("ч", "ƌ");
        put("Ч", "Ƌ");

        put("чъ", "ɖ");
        put("Чъ", "Ɖ");
        put("чЪ", "ɖ");
        put("ЧЪ", "Ɖ");

        put("чl", "ḍ");
        put("Чl", "Ḍ");
        put("ЧL", "Ḍ");
        put("ч1", "ḍ");
        put("Ч1", "Ḍ");
        put("ч|", "ḍ");
        put("Ч|", "Ḍ");
        put("ч'", "ḍ");
        put("Ч'", "Ḍ");
        put("ч’", "ḍ");
        put("Ч’", "Ḍ");
        put("чӀ", "ḍ");
        put("ЧӀ", "Ḍ");
        put("чI", "ḍ");
        put("ЧI", "Ḍ");
        put("чi", "ḍ");
        put("Чi", "Ḍ");

        put("ш", "ħ");
        put("Ш", "Ħ");

        put("шъ", "š");
        put("Шъ", "Š");
        put("шЪ", "š");
        put("ШЪ", "Š");

        put("шl", "ꜧ");
        put("Шl", "Ӈ");
        put("ШL", "Ӈ");
        put("ш1", "ꜧ");
        put("Ш1", "Ӈ");
        put("ш|", "ꜧ");
        put("Ш|", "Ӈ");
        put("ш'", "ꜧ");
        put("Ш'", "Ӈ");
        put("ш’", "ꜧ");
        put("Ш’", "Ӈ");
        put("шӀ", "ꜧ");
        put("ШӀ", "Ӈ");
        put("шI", "ꜧ");
        put("ШI", "Ӈ");
        put("шi", "ꜧ");
        put("Шi", "Ӈ");

        put("щ", "ʃ");
        put("Щ", "Ʃ");

        put("щl", "ṣ");
        put("Щl", "Ṣ");
        put("ЩL", "Ṣ");
        put("щ1", "ṣ");
        put("Щ1", "Ṣ");
        put("щ|", "ṣ");
        put("Щ|", "Ṣ");
        put("щ'", "ṣ");
        put("Щ'", "Ṣ");
        put("щ’", "ṣ");
        put("Щ’", "Ṣ");
        put("щӀ", "ṣ");
        put("ЩӀ", "Ṣ");
        put("щI", "ṣ");
        put("ЩI", "Ṣ");
        put("щi", "ṣ");
        put("Щi", "Ṣ");

        put("ы", "ǝ");
        put("Ы", "Ǝ");
        put("э", "э");
        put("Э", "Э");
        put("ю", "yu");
        put("Ю", "Yu");
        put("я", "ya");
        put("Я", "Ya");

        put("l", "h");
        put("1", "h");
        put("|", "h");
        put("Ӏ", "h");
        put("I", "h");
        put("i", "h");

        put("ъ", "");
        put("ь", "");
        put("Ъ", "");
        put("Ь", "");
    }};

    private Map<String, String> weirdLetter = new HashMap<>() {{
        put("l", "h");
        put("1", "h");
        put("|", "h");
        put("Ӏ", "h");
        put("I", "h");
        put("i", "h");
    }};

    public String printAlphabet() {
        int count = 0;
        StringBuilder result = new StringBuilder();
        ArrayList<Map.Entry<String, String>> entries = new ArrayList<>(alphabetToShow.entrySet());
        for (int i = 0; i < entries.size() - 1; i+=2) {
            result.append(entries.get(i).getKey()).append(" ").append(entries.get(i + 1).getKey()).append(": ")
                    .append(entries.get(i).getValue()).append(" ").append(entries.get(i + 1).getValue());
            result.append("""
                    """);
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
