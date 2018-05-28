package section1_intro.part1_language_basics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanguageBasicsTest {
    private LanguageBasics languageBasics;

    @BeforeEach
    void setUp(){
        this.languageBasics = new LanguageBasics();
    }

    @Test
    void returnCorrectlyNamedVariable() {
        String value = this.languageBasics.returnCorrectlyNamedVariable();
        assertEquals("Louis XIV, le Roi Soleil", value);
    }

    @Test
    void callCorrectlyNamedMethod() {
        int value = this.languageBasics.callCorrectlyNamedMethod();
        assertEquals(2, value);
    }

    @Test
    void distanceTo() {
        LanguageBasics.PointInSpace p1 = new LanguageBasics.PointInSpace();
        p1.x = 0;
        p1.y = 0;

        LanguageBasics.PointInSpace p2 = new LanguageBasics.PointInSpace();
        p2.x = 0;
        p2.y = 0;

        assertEquals(0, p1.distanceTo(p2));

        p1.x = 2;
        p1.y = 2;

        p2.x = 4;
        p2.y = 4;

        assertEquals(Math.sqrt(8), p1.distanceTo(p2));
    }

    @Test
    void surface() {
        LanguageBasics.PointInSpace p1 = new LanguageBasics.PointInSpace();
        p1.x = 2;
        p1.y = 8;

        LanguageBasics.PointInSpace p2 = new LanguageBasics.PointInSpace();
        p2.x = 10;
        p2.y = 3;

        LanguageBasics.SquareInSpace square = new LanguageBasics.SquareInSpace();
        square.upperLeft = p1;
        square.lowerRight = p2;

        assertEquals((5*8), square.surface());

        p1.x = 5;
        p1.y = 12;
        p2.x = 8;
        p2.y = 1;

        assertEquals((11*3), square.surface());
    }
}