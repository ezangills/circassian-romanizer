package org.tsei.romanizer.service;

import org.junit.jupiter.api.Test;

public class RomanizerServiceTest {

    @Test
    public void testRomanizerOneWord() {
        RomanizerService romanizerService = new RomanizerService();
        String strOne = "Мыекъуапэ";
        System.out.println("1.");
        System.out.println(strOne);
        System.out.println(romanizerService.romanize(strOne));
        System.out.println();
        String strTwo = "къэлэ";
        System.out.println("2.");
        System.out.println(strTwo);
        System.out.println(romanizerService.romanize(strTwo));
        System.out.println();
        String strThree = "дах";
        System.out.println("3.");
        System.out.println(strThree);
        System.out.println(romanizerService.romanize(strThree));
        String strFour = "Ти Мыекъуапэ къэлэ дах. Ар урам зэнкӀабзэхэмкӀэ зэтеутыгъэ. Ахэмэ чъыг сатыр дахэхэр атетых. Тыдэ уплъагъэми урамхэр къабзэх.";
        System.out.println();
        System.out.println("4.");
        System.out.println(strFour);
        System.out.println(romanizerService.romanize(strFour));
    }
}
