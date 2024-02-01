package org.tsei.romanizer.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RomanizerServiceTest {

    @Test
    public void testRomanizerOneWord() {
        RomanizerService romanizerService = new RomanizerService();
        String input = "Мыекъуапэ";
        String output = "Mɨeqvapǝ";
        assertEquals(output, romanizerService.romanize(input));
    }

    @Test
    public void testRomanizerSecondWord() {
        RomanizerService romanizerService = new RomanizerService();
        String input = "къэлэ";
        String output = "qǝlǝ";
        assertEquals(output, romanizerService.romanize(input));
    }

    @Test
    public void testRomanizerThirdWord() {
        RomanizerService romanizerService = new RomanizerService();
        String input = "дах";
        String output = "dax";
        assertEquals(output, romanizerService.romanize(input));
    }

    @Test
    public void testRomanizerSentenceOne() {
        RomanizerService romanizerService = new RomanizerService();
        String input = "Ти Мыекъуапэ къэлэ дах. Ар урам зэнкӀабзэхэмкӀэ зэтеутыгъэ. Ахэмэ чъыг сатыр дахэхэр атетых. Тыдэ уплъагъэми урамхэр къабзэх.";
        String output = "Ti Mɨeqvapǝ qǝlǝ dax. Ar vram zǝnⱪabzǝxǝmⱪǝ zǝtevtɨгǝ. Axǝmǝ ħɨg satɨr daxǝxǝr atetɨx. Tɨdǝ vpłaгǝmi vramxǝr qabzǝx.";
        assertEquals(output, romanizerService.romanize(input));
    }

    @Test
    public void testRomanizerSentenceTwo() {
        RomanizerService romanizerService = new RomanizerService();
        String input = "Ти Мыекъуапэ къэлэ дах. Ар урам зэнкӀабзэхэмкӀэ зэтеутыгъэ. Ахэмэ чъыг сатыр дахэхэр атетых. Тыдэ уплъагъэми урамхэр къабзэх. Мыекъуапэ икъыблэ лъэныкъокӀэ псыхъоу Шъхьэгуащэ речъэкӀы. Псыхъом ыкӀыбкӀэ мэз Ӏужъу зытет къушъхьэ лъагэхэр къалэм къышъхьарэплъэх. Зы бгъумкӀэ бгы  лъагэр къалэм рекӀокӀы, адрэбгъумкӀэ чӀыгур зэныбжь. А чӀыгу зэныбжьым унакӀэхэр бэу зэтетхэу щашӀых.";
        String output = "Ti Mɨeqvapǝ qǝlǝ dax. Ar vram zǝnⱪabzǝxǝmⱪǝ zǝtevtɨгǝ. Axǝmǝ ħɨg satɨr daxǝxǝr atetɨx. Tɨdǝ vpłaгǝmi vramxǝr qabzǝx. Mɨeqvapǝ iqɨblǝ łǝnɨqoⱪǝ psɨҳov Šẍǝgvaʃǝ reħǝⱪɨ. Psɨҳom ɨⱪɨbⱪǝ mǝz ƪvⲍv zɨtet qvšẍǝ łagǝxǝr qalǝm qɨšẍarǝpłǝx. Zɨ bгvmⱪǝ bgɨ  łagǝr qalǝm reⱪoⱪɨ, adrǝbгvmⱪǝ ꜧɨgvr zǝnɨbɩ. A ꜧɨgv zǝnɨbɩɨm vnaⱪǝxǝr bǝv zǝtetxǝv ʃaṣɨx.";
        System.out.println(output);
        assertEquals(output, romanizerService.romanize(input));
    }

    @Test
    public void testI() {
        RomanizerService romanizerService = new RomanizerService();
        String input = "янэ сэпIыс. янэ сэп1ыс. янэ сэпIыс. янэ сэпiыс. янэ сэп|ыс. янэ сэп’ыс.";
        String output = "ânǝ sǝᵽɨs. ânǝ sǝᵽɨs. ânǝ sǝᵽɨs. ânǝ sǝᵽɨs. ânǝ sǝᵽɨs. ânǝ sǝᵽɨs.";
        assertEquals(output, romanizerService.romanize(input));
    }

    @Test
    public void testTwo() {
        RomanizerService romanizerService = new RomanizerService();
        String input = "IаплI";
        String output = "ƪapḷ";
        assertEquals(output, romanizerService.romanize(input));
    }

    @Test
    public void testPrintAlphabet() {
        RomanizerService romanizerService = new RomanizerService();
        System.out.println(romanizerService.printAlphabet());
    }

    @Test
    public void testAlphabetsAreSame() {
        RomanizerService romanizerService = new RomanizerService();
        Set<String> values1 = new HashSet<>(romanizerService.getAlphabet().values());
        Set<String> values2 = new HashSet<>(romanizerService.getAlphabetToShow().values());
        Set<String> keys1 = new HashSet<>(romanizerService.getAlphabet().keySet());
        Set<String> keys2 = new HashSet<>(romanizerService.getAlphabetToShow().keySet());
        assertTrue(values1.containsAll(values2));
        assertTrue(values2.containsAll(values1));
        assertTrue(keys1.containsAll(keys2));
    }
}
