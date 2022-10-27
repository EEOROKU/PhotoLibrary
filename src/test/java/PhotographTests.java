import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.Timeout;

import photos.Photograph;

public class PhotographTests {
    @Timeout(100)
    @Test
    public void testConstructorCaptionSet() {
        Photograph b = new Photograph("mypic.jpg", "Grand Canyon");
        assertEquals( "Grand Canyon", b.getCaption(),"Original photograph constructor (or getter) failed for caption");

    }

    @Timeout(100)
    @Test
    public void testConstructorFilenameSet() {

        //code for TODO 3 here

    }


    @Timeout(100)
    @Test
    public void equalsType() throws Exception {
        try {
            Photograph.class.getDeclaredMethod("equals", Object.class);
        } catch (NoSuchMethodException e) {
            fail("Photograph equals method not specified correctly.");
        } catch (Exception e) {
            throw e;
        }
    }

    @Timeout(100)
    @Test
    public void equalsSame() {
        Photograph b = new Photograph("mypic3.jpg", "Grand Canyon 2");
        assertTrue(b.equals(b),"Photograph.equals() failed: Not symmetric");
    }

    @Timeout(100)
    @Test
    public void equalsSimilar() {
        Photograph b = new Photograph("mypic3.jpg", "Grand Canyon 3");
        Photograph c = new Photograph("mypic3.jpg", "Grand Canyon 3");
        assertTrue(b.equals(c),"Photograph.equals() failed: Two photographs with same caption and file name not equal");
    }


    @Test
    public void equalsDifferentCaptions() {
        Photograph b = new Photograph("mypic3.jpg", "Grand Canyon 54");
        Photograph c = new Photograph("mypic3.jpg", "Grand Canyon 3");
        assertFalse(b.equals(c), "Photograph.equals() failed: Same filename, different captions");
    }

    @Test
    public void equalsDifferentFilenames() {
        Photograph b = new Photograph("mypic3.jpg", "Grand Canyon 3");
        Photograph c = new Photograph("mypic55.jpg", "Grand Canyon 3");
        assertFalse(b.equals(c),"Photograph.equals() failed: Same caption, different filenames");
    }


    @Test
    public void equalsEverythingDifferent() {
        Photograph b = new Photograph("newpic.jpg", "Grand Canyon");
        Photograph c = new Photograph("yos.jpg", "Yosemite");
        assertFalse(b.equals(c),"Photograph.equals() failed: Different caption, different filenames");
    }

    @Timeout(100)
    @Test
    public void equalsDifferentTypes() throws Exception {
        try {
            Photograph b = new Photograph("yosemite.png", "Family Vacation");
            assertFalse(b.equals(42), "Photograph.equals() failed: Compared Photograph to Integer");
        } catch (ClassCastException e) {
            fail("Photograph.equals() failed: Casting a non-Photograph to a Photograph");
        } catch (Exception e) {
            throw e;
        }
    }


    @Timeout(100)
    @Test
    public void testToString() {
        Photograph b = new Photograph("yosemite.png", "Family Vacation");
        String s = b.toString();
        assertTrue(s.contains("Family Vacation"), "Photograph.toString must have caption");
        assertTrue( s.contains("yosemite.png"), "Photograph.toString must have filename");
    }

}
