package tdd.romanNumeralsHelper;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralsTest {

    private RomanNumerals romanNumerals;
    private static LocalDateTime start;
    private static LocalDateTime end;

    @BeforeAll
    static void beforeAll() {
        start = LocalDateTime.now();
        System.out.println(start.format(DateTimeFormatter.ofPattern("mm:ss.SSS")));
    }

    @AfterAll
    static void afterAll() {
        end = LocalDateTime.now();
        System.out.println(end.format(DateTimeFormatter.ofPattern("mm:ss.SSS")));
        System.out.println(
                end.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
                        - start.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println();
    }

    @BeforeEach
    void setUp() {
        romanNumerals = new RomanNumerals();
    }

    @Test
    void toRoman_whenIrregularInput_thenException() {
        assertThrows(Exception.class, () -> romanNumerals.toRoman(0));
        assertThrows(Exception.class, () -> romanNumerals.toRoman(-1));
        assertThrows(Exception.class, () -> romanNumerals.toRoman(4000));
        assertThrows(Exception.class, () -> romanNumerals.toRoman(40001));
    }

    @Test
    void toRoman_when1_thenI() throws Exception {
        assertEquals("I", romanNumerals.toRoman(1));
    }

    @Test
    void toRoman_when2_thenII() throws Exception {
        assertEquals("II", romanNumerals.toRoman(2));
    }

    @Test
    void toRoman_when3_thenIII() throws Exception {
        assertEquals("III", romanNumerals.toRoman(3));
    }

    @Test
    void toRoman_when4_thenIV() throws Exception {
        assertEquals("IV", romanNumerals.toRoman(4));
    }

    @Test
    void toRoman_when5_thenV() throws Exception {
        assertEquals("V", romanNumerals.toRoman(5));
    }

    @Test
    void toRoman_when6_thenVI() throws Exception {
        assertEquals("VI", romanNumerals.toRoman(6));
    }

    @Test
    void toRoman_when7_thenVII() throws Exception {
        assertEquals("VII", romanNumerals.toRoman(7));
    }

    @Test
    void toRoman_when8_thenVIII() throws Exception {
        assertEquals("VIII", romanNumerals.toRoman(8));
    }

    @Test
    void toRoman_when9_thenIX() throws Exception {
        assertEquals("IX", romanNumerals.toRoman(9));
    }

    @Test
    void toRoman_when10_thenX() throws Exception {
        assertEquals("X", romanNumerals.toRoman(10));
    }

    @Test
    void toRoman_when11_thenXI() throws Exception {
        assertEquals("XI", romanNumerals.toRoman(11));
    }

    @Test
    void toRoman_when12_thenXII() throws Exception {
        assertEquals("XII", romanNumerals.toRoman(12));
    }

    @Test
    void toRoman_when19_thenXIX() throws Exception {
        assertEquals("XIX", romanNumerals.toRoman(19));
    }

    @Test
    void toRoman_when20_thenXX() throws Exception {
        assertEquals("XX", romanNumerals.toRoman(20));
    }

    @Test
    void toRoman_when40_thenXL() throws Exception {
        assertEquals("XL", romanNumerals.toRoman(40));
    }

    @Test
    void toRoman_when49_thenXLIX() throws Exception {
        assertEquals("XLIX", romanNumerals.toRoman(49));
    }

    @Test
    void toRoman_when90_thenXC() throws Exception {
        assertEquals("XC", romanNumerals.toRoman(90));
    }

    @Test
    void toRoman_when99_thenXCIX() throws Exception {
        assertEquals("XCIX", romanNumerals.toRoman(99));
    }

    @Test
    void toRoman_when100_thenC() throws Exception {
        assertEquals("C", romanNumerals.toRoman(100));
    }

    @Test
    void toRoman_when199_thenCXCIX() throws Exception {
        assertEquals("CXCIX", romanNumerals.toRoman(199));
    }

    @Test
    void toRoman_when499_thenCDXCIX() throws Exception {
        assertEquals("CDXCIX", romanNumerals.toRoman(499));
    }

    @Test
    void toRoman_when500_thenD() throws Exception {
        assertEquals("D", romanNumerals.toRoman(500));
    }

    @Test
    void toRoman_when999_thenCMXCIX() throws Exception {
        assertEquals("CMXCIX", romanNumerals.toRoman(999));
    }

    @Test
    void toRoman_when3999_thenMMMCMXCIX() throws Exception {
        assertEquals("MMMCMXCIX", romanNumerals.toRoman(3999));
    }

    @Test
    void toRoman_when2008_thenMMVIII() throws Exception {
        assertEquals("MMVIII", romanNumerals.toRoman(2008));
    }

    @Test
    void fromRoman_whenI_then1() {
        assertEquals(1, romanNumerals.fromRoman("I"));
    }

    @Test
    void fromRoman_whenII_then2() {
        assertEquals(2, romanNumerals.fromRoman("II"));
    }

    @Test
    void fromRoman_whenIII_then3() {
        assertEquals(3, romanNumerals.fromRoman("III"));
    }

    @Test
    void fromRoman_whenIV_then4() {
        assertEquals(4, romanNumerals.fromRoman("IV"));
    }

    @Test
    void fromRoman_whenV_then5() {
        assertEquals(5, romanNumerals.fromRoman("V"));
    }

    @Test
    void fromRoman_whenVI_then6() {
        assertEquals(6, romanNumerals.fromRoman("VI"));
    }

    @Test
    void fromRoman_whenVIII_then8() {
        assertEquals(8, romanNumerals.fromRoman("VIII"));
    }

    @Test
    void fromRoman_whenX_then10() {
        assertEquals(10, romanNumerals.fromRoman("X"));
    }

    @Test
    void fromRoman_whenIX_then9() {
        assertEquals(9, romanNumerals.fromRoman("IX"));
    }

    @Test
    void fromRoman_whenXI_then11() {
        assertEquals(11, romanNumerals.fromRoman("XI"));
    }

    @Test
    void fromRoman_whenXIII_then13() {
        assertEquals(13, romanNumerals.fromRoman("XIII"));
    }

    @Test
    void fromRoman_whenXIV_then14() {
        assertEquals(14, romanNumerals.fromRoman("XIV"));
    }

    @Test
    void fromRoman_whenXV_then15() {
        assertEquals(15, romanNumerals.fromRoman("XV"));
    }

    @Test
    void fromRoman_whenXVI_then16() {
        assertEquals(16, romanNumerals.fromRoman("XVI"));
    }

    @Test
    void fromRoman_whenXVIII_then18() {
        assertEquals(18, romanNumerals.fromRoman("XVIII"));
    }

    @Test
    void fromRoman_whenXIX_then19() {
        assertEquals(19, romanNumerals.fromRoman("XIX"));
    }

    @Test
    void fromRoman_whenXX_then20() {
        assertEquals(20, romanNumerals.fromRoman("XX"));
    }

    @Test
    void fromRoman_whenXXI_then21() {
        assertEquals(21, romanNumerals.fromRoman("XXI"));
    }

    @Test
    void fromRoman_whenXXIX_then29() {
        assertEquals(29, romanNumerals.fromRoman("XXIX"));
    }

    @Test
    void fromRoman_whenXL_then40() {
        assertEquals(40, romanNumerals.fromRoman("XL"));
    }

    @Test
    void fromRoman_whenXLIX_then49() {
        assertEquals(49, romanNumerals.fromRoman("XLIX"));
    }

    @Test
    void fromRoman_whenLI_then51() {
        assertEquals(51, romanNumerals.fromRoman("LI"));
    }

    @Test
    void fromRoman_whenLXXX_then80() {
        assertEquals(80, romanNumerals.fromRoman("LXXX"));
    }

    @Test
    void fromRoman_whenXC_then90() {
        assertEquals(90, romanNumerals.fromRoman("XC"));
    }

    @Test
    void fromRoman_whenXCIV_then9e() {
        assertEquals(94, romanNumerals.fromRoman("XCIV"));
    }

    @Test
    void fromRoman_whenXCV_then95() {
        assertEquals(95, romanNumerals.fromRoman("XCV"));
    }

    @Test
    void fromRoman_whenXCVIII_then98() {
        assertEquals(98, romanNumerals.fromRoman("XCVIII"));
    }

    @Test
    void fromRoman_whenXCIX_then99() {
        assertEquals(99, romanNumerals.fromRoman("XCIX"));
    }

    @Test
    void fromRoman_whenC_then100() {
        assertEquals(100, romanNumerals.fromRoman("C"));
    }

    @Test
    void fromRoman_whenCI_then101() {
        assertEquals(101, romanNumerals.fromRoman("CI"));
    }

    @Test
    void fromRoman_whenDI_then501() {
        assertEquals(501, romanNumerals.fromRoman("DI"));
    }

    @Test
    void fromRoman_whenCMXCIX_then999() {
        assertEquals(999, romanNumerals.fromRoman("CMXCIX"));
    }

    @Test
    void fromRoman_whenM_then1000() {
        assertEquals(1000, romanNumerals.fromRoman("M"));
    }

    @Test
    void fromRoman_whenMI_then1001() {
        assertEquals(1001, romanNumerals.fromRoman("MI"));
    }

    @Test
    void fromRoman_whenMCMI_then1901() {
        assertEquals(1901, romanNumerals.fromRoman("MCMI"));
    }

    @Test
    void fromRoman_whenMMMCMXCI_then3991() {
        assertEquals(3991, romanNumerals.fromRoman("MMMCMXCI"));
    }

    @Test
    void fromRoman_whenMMMCMXCIX_then3999() {
        assertEquals(3999, romanNumerals.fromRoman("MMMCMXCIX"));
    }








}
