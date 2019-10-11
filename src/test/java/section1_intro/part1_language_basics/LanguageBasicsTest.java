package section1_intro.part1_language_basics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LanguageBasicsTest {
    private LanguageBasics languageBasics;

    @BeforeEach
    void setUp(){
        this.languageBasics = new LanguageBasics();
    }

    @Test
    void testGetTheAbsolutePower() {
        assertThat(languageBasics.getTheAbsolutePower(5, 3)).isEqualTo(125);
        assertThat(languageBasics.getTheAbsolutePower(5, -3)).isEqualTo(125);
        assertThat(languageBasics.getTheAbsolutePower(2, 2)).isEqualTo(4);
        assertThat(languageBasics.getTheAbsolutePower(-2, 2)).isEqualTo(4);
        assertThat(languageBasics.getTheAbsolutePower(-2, -3)).isEqualTo(-8);
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

}