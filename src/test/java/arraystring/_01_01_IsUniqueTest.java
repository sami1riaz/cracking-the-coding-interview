package arraystring;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _01_01_IsUniqueTest {

    private _01_01_IsUnique s = new _01_01_IsUnique();

    @Test
    public void withEmptyString() {
        assertTrue(s.isUnique(""));
    }

    @Test
    public void withUniqueString() {
        assertTrue(s.isUnique("abcde"));
    }

    @Test
    public void withDuplication() {
        assertFalse(s.isUnique("abcda"));
    }

    @Test
    public void tooLong() {
        assertFalse(s.isUnique("abcaduhfljadhglshglshgljsdhgldsf;dksjgldsjhg;dsogsdlghdlsaghasldghalsdgh;lasugh;lsidghosifhglsadghlsdghowureghpq3ruygp943ut09378605708t5-9t 30thgijhrgh3iptu349tu3480tyo3uipti34touhroif8234yt 80u49-tu423-9tuw9uqfy3478y0438534tifddhuehfohfgksdhgfkasdhgfkhgsfkghfksjdgh"));
    }

}