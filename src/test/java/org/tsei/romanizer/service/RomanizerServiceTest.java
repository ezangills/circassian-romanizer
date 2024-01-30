package org.tsei.romanizer.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanizerServiceTest {

    @Test
    public void testRomanizerOneWord() {
        RomanizerService romanizerService = new RomanizerService();
        String input = "Мыекъуапэ";
        String output = "Mǝeqvapэ";
        assertEquals(output, romanizerService.romanize(input));
    }

    @Test
    public void testRomanizerSecondWord() {
        RomanizerService romanizerService = new RomanizerService();
        String input = "къэлэ";
        String output = "qэlэ";
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
        String output = "Ti Mǝeqvapэ qэlэ dax. Ar vram zэnⱪabzэxэmⱪэ zэtevtǝгэ. Axэmэ ɖǝg satǝr daxэxэr atetǝx. Tǝdэ vpłaгэmi vramxэr qabzэx.";
        assertEquals(output, romanizerService.romanize(input));
    }

    @Test
    public void testRomanizerSentenceTwo() {
        RomanizerService romanizerService = new RomanizerService();
        String input = "Ти Мыекъуапэ къэлэ дах. Ар урам зэнкӀабзэхэмкӀэ зэтеутыгъэ. Ахэмэ чъыг сатыр дахэхэр атетых. Тыдэ уплъагъэми урамхэр къабзэх. Мыекъуапэ икъыблэ лъэныкъокӀэ псыхъоу Шъхьэгуащэ речъэкӀы. Псыхъом ыкӀыбкӀэ мэз Ӏужъу зытет къушъхьэ лъагэхэр къалэм къышъхьарэплъэх. Зы бгъумкӀэ бгы  лъагэр къалэм рекӀокӀы, адрэбгъумкӀэ чӀыгур зэныбжь. А чӀыгу зэныбжьым унакӀэхэр бэу зэтетхэу щашӀых.";
        String output = "Ti Mǝeqvapэ qэlэ dax. Ar vram zэnⱪabzэxэmⱪэ zэtevtǝгэ. Axэmэ ɖǝg satǝr daxэxэr atetǝx. Tǝdэ vpłaгэmi vramxэr qabzэx. Mǝeqvapэ iqǝblэ łэnǝqoⱪэ psǝҳov Šḩэgvaʃэ reɖэⱪǝ. Psǝҳom ǝⱪǝbⱪэ mэz hvⲍv zǝtet qvšḩэ łagэxэr qalэm qǝšḩarэpłэx. Zǝ bгvmⱪэ bgǝ  łagэr qalэm reⱪoⱪǝ, adrэbгvmⱪэ ḍǝgvr zэnǝbե. A ḍǝgv zэnǝbեǝm vnaⱪэxэr bэv zэtetxэv ʃaꜧǝx.";
        System.out.println(output);
        assertEquals(output, romanizerService.romanize(input));
    }

    @Test
    public void testI() {
        RomanizerService romanizerService = new RomanizerService();
        String input = "янэ сэпIыс. янэ сэп1ыс. янэ сэпIыс. янэ сэпiыс. янэ сэп|ыс. янэ сэп’ыс.";
        String output = "yanэ sэᵽǝs. yanэ sэᵽǝs. yanэ sэᵽǝs. yanэ sэᵽǝs. yanэ sэᵽǝs. yanэ sэᵽǝs.";
        assertEquals(output, romanizerService.romanize(input));
    }

    @Test
    public void testTwo() {
        RomanizerService romanizerService = new RomanizerService();
        String input = "IаплI";
        String output = "hapḷ";
        assertEquals(output, romanizerService.romanize(input));
    }
}
