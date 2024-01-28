package org.tsei.romanizer.service;

import java.util.HashMap;
import java.util.Map;

public class RomanizerService {

    Map<String, String> alphabet = new HashMap<>() {{
        put("а", "a");
        put("А", "A");
        put("б", "b");
        put("Б", "B");
        put("в", "w");
        put("В", "W");
        put("г", "g");
        put("Г", "G");
        put("гу", "gv");
        put("Гу", "Gv");
        put("гъ", "г");
        put("Гъ", "Г");
        put("гъу", "гv");
        put("Гъу", "Гv");
        put("д", "d");
        put("Д", "D");
        put("дж", "ǥ");
        put("Дж", "Ǥ");
        put("дз", "ʒ");
        put("Дз", "Ʒ");
        put("дзу", "ʒv");
        put("Дзу", "Ʒv");
        put("е", "e");
        put("Е", "E");
        put("ё", "e");
        put("Ё", "E");
        put("ж", "j");
        put("Ж", "J");
        put("жъ", "ⲍ");
        put("Жъ", "Ⲍ");
        put("жъу", "ⲍv");
        put("Жъу", "Ⲍv");
        put("жь", "ե");
        put("Жь", "Ե");
        put("з", "z");
        put("З", "Z");
        put("и", "i");
        put("И", "I");
        put("й", "y");
        put("Й", "Y");
        put("к", "k");
        put("К", "K");
        put("ку", "kv");
        put("Ку", "Kv");
        put("къ", "q");
        put("Къ", "Q");
        put("Къу", "Qv");

        put("кl", "ⱪ");
        put("Кl", "Ⱪ");
        put("к1", "ⱪ");
        put("К1", "Ⱪ");
        put("к|", "ⱪ");
        put("К|", "Ⱪ");
        put("к'", "ⱪ");
        put("К'", "Ⱪ");
        put("кӀ", "ⱪ");
        put("КӀ", "Ⱪ");

        put("кlу", "ⱪv");
        put("Кlу", "Ⱪv");
        put("к1у", "ⱪv");
        put("К1у", "Ⱪv");
        put("к|у", "ⱪv");
        put("К|у", "Ⱪv");
        put("к'у", "ⱪv");
        put("К'у", "Ⱪv");
        put("кӀу", "ⱪv");
        put("КӀу", "Ⱪv");

        put("л", "l");
        put("Л", "L");
        put("лъ", "ł");
        put("Лъ", "Ł");

        put("лl", "ḷ");
        put("Лl", "Ḷ");
        put("л1", "ḷ");
        put("Л1", "Ḷ");
        put("л|", "ḷ");
        put("Л|", "Ḷ");
        put("л'", "ḷ");
        put("Л'", "Ḷ");
        put("лӀ", "ḷ");
        put("ЛӀ", "Ḷ");

        put("м", "m");
        put("М", "M");
        put("н", "n");
        put("Н", "N");
        put("о", "o");
        put("О", "O");
        put("п", "p");
        put("П", "P");

        put("пl", "ꝓ");
        put("Пl", "Ꝓ");
        put("п1", "ꝓ");
        put("П1", "Ꝓ");
        put("п|", "ꝓ");
        put("П|", "Ꝓ");
        put("п'", "ꝓ");
        put("П'", "Ꝓ");
        put("пӀ", "ꝓ");
        put("ПӀ", "Ꝓ");

        put("пlу", "ꝓv");
        put("Пlу", "Ꝓv");
        put("п1у", "ꝓv");
        put("П1у", "Ꝓv");
        put("п|у", "ꝓv");
        put("П|у", "Ꝓv");
        put("п'у", "ꝓv");
        put("П'у", "Ꝓv");
        put("пӀу", "ꝓv");
        put("ПӀу", "Ꝓv");

        put("р", "r");
        put("Р", "R");
        put("с", "s");
        put("С", "S");
        put("т", "t");
        put("Т", "T");

        put("тl", "ţ");
        put("Тl", "Ţ");
        put("т1", "ţ");
        put("Т1", "Ţ");
        put("т|", "ţ");
        put("Т|", "Ţ");
        put("т'", "ţ");
        put("Т'", "Ţ");
        put("тӀ", "ţ");
        put("ТӀ", "Ţ");

        put("тlу", "ţv");
        put("Тlу", "Ţv");
        put("т1у", "ţv");
        put("Т1у", "Ţv");
        put("т|у", "ţv");
        put("Т|у", "Ţv");
        put("т'у", "ţv");
        put("Т'у", "Ţv");
        put("тӀу", "ţv");
        put("ТӀу", "Ţv");

        put("у", "v");
        put("У", "V");
        put("ф", "f");
        put("Ф", "F");
        put("х", "x");
        put("Х", "X");
        put("хъ", "ҳ");
        put("Хъ", "Ҳ");
        put("хъу", "ҳv");
        put("Хъу", "Ҳv");
        put("хь", "ɦ");
        put("Хь", "Ɦ");
        put("ц", "c");
        put("Ц", "C");
        put("цу", "cv");
        put("Цу", "Cv");

        put("цl", "ç");
        put("Цl", "Ç");
        put("ц1", "ç");
        put("Ц1", "Ç");
        put("ц|", "ç");
        put("Ц|", "Ç");
        put("ц'", "ç");
        put("Ц'", "Ç");
        put("цӀ", "ç");
        put("ЦӀ", "Ç");

        put("ч", "ꝁ");
        put("Ч", "Ꝁ");
        put("чъ", "đ");
        put("Чъ", "Đ");

        put("чl", "ḍ");
        put("Чl", "Ḍ");
        put("ч1", "ḍ");
        put("Ч1", "Ḍ");
        put("ч|", "ḍ");
        put("Ч|", "Ḍ");
        put("ч'", "ḍ");
        put("Ч'", "Ḍ");
        put("чӀ", "ḍ");
        put("ЧӀ", "Ḍ");

        put("ш", "ħ");
        put("Ш", "Ħ");
        put("шъ", "š");
        put("Шъ", "Š");
        put("шъу", "šv");
        put("Шъу", "Šv");

        put("шl", "ꜧ");
        put("Шl", "Ꜧ");
        put("ш1", "ꜧ");
        put("Ш1", "Ꜧ");
        put("ш|", "ꜧ");
        put("Ш|", "Ꜧ");
        put("ш'", "ꜧ");
        put("Ш'", "Ꜧ");
        put("шӀ", "ꜧ");
        put("ШӀ", "Ꜧ");

        put("шlу", "ꜧv");
        put("Шlу", "Ꜧv");
        put("ш1у", "ꜧv");
        put("Ш1у", "Ꜧv");
        put("ш|у", "ꜧv");
        put("Ш|у", "Ꜧv");
        put("ш'у", "ꜧv");
        put("Ш'у", "Ꜧv");
        put("шӀу", "ꜧv");
        put("ШӀу", "Ꜧv");

        put("щ", "ʃ");
        put("Щ", "Ʃ");
        put("ы", "ǝ");
        put("Ы", "Ǝ");
        put("э", "э");
        put("Э", "Э");
        put("ю", "iu");
        put("Ю", "Iu");
        put("я", "ia");
        put("Я", "Ia");

        put("l", "h");
        put("1", "h");
        put("|", "h");
        put("Ӏ", "h");

        put("lу", "hv");
        put("1у", "hv");
        put("|у", "hv");
        put("Ӏу", "hv");
    }};

    private Map<String, String> weirdLetter = new HashMap<>() {{
        put("l", "h");
        put("1", "h");
        put("|", "h");
    }};



    public String romanize(String cyrillicVersion) {
        StringBuilder romanizedVersion = new StringBuilder();
        for (int index = 0; index < cyrillicVersion.length(); index++) {
            if (Character.UnicodeBlock.of(cyrillicVersion.charAt(index)).equals(Character.UnicodeBlock.CYRILLIC)
                                    || weirdLetter.containsKey(String.valueOf(cyrillicVersion.charAt(index)))) {
                int endOfWordIndex = index;
                while ((Character.UnicodeBlock.of(cyrillicVersion.charAt(endOfWordIndex)).equals(Character.UnicodeBlock.CYRILLIC)
                        || weirdLetter.containsKey(String.valueOf(cyrillicVersion.charAt(endOfWordIndex)))) && endOfWordIndex < cyrillicVersion.length() - 1) {
                    endOfWordIndex++;
                }

                while (!alphabet.containsKey(cyrillicVersion.substring(index, endOfWordIndex)) && endOfWordIndex > index) {
                    endOfWordIndex--;
                }

                if (endOfWordIndex != index) {
                    romanizedVersion.append(alphabet.get(cyrillicVersion.substring(index, endOfWordIndex)));
                    index = endOfWordIndex - 1;
                } else {
                    romanizedVersion.append(cyrillicVersion.charAt(index));
                }
            } else {
                romanizedVersion.append(cyrillicVersion.charAt(index));
            }
        }
        return romanizedVersion.toString();
    }

}