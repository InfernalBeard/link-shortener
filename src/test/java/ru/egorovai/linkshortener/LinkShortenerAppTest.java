package ru.egorovai.linkshortener;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkShortenerAppTest {

    @Test
    void test() {
        byte b;     // -128 до 127 (1 байт)
        short s;    // -32,768 до 32,767 (2 байта)
        int i;      // -2,147,483,648 до 2,147,483,647 (4 байта)
        long l;     // -9,223,372,036,854,775,808 до 9,223,372,036,854,775,807 (8 байт)
        float f;    // ~6-7 значащих цифр (1.4E-45 до 3.4E+38) (4 байта)
        double d;   // ~15-16 значащих цифр (4.9E-324 до 1.7E+308) (8 байт)
        char c;     // Символы Unicode (0 до 65,535) (2 байта)
        boolean bool; // true или false (1 байт*)
    }


}