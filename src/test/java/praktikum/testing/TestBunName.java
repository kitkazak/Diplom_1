package praktikum.testing;

import org.junit.Test;
import praktikum.Bun;

public class TestBunName {

    @Test(expected = Exception.class)
    public void emptyNameIsNotAllowed() {
        new Bun("", 100);
    }

    @Test(expected = Exception.class)
    public void nullNameIsNotAllowed() {
        new Bun(null, 100);
    }

    @Test
    public void veryLongNameIsAllowed() {
        String veryLongString = " ".repeat(100000);
        new Bun(veryLongString, 100);
    }

    @Test(expected = Exception.class)
    public void specialSymbolsAreNotAllowed() {
        new Bun("Name\t\b\n\r\f'\"\\", 100);
    }
}
