package javaTesting.ExplorantJUnit;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ExplorantjUnitTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void testejantIllegalArgumentException(){

        throw new IllegalArgumentException();
    }

    @Ignore
    @Test
    public void illegalParametersTest(){

        expected.expect(IllegalArgumentException.class);
        throw new IllegalArgumentException();
    }

    @Test
    public void missatgeExepcioTest(){

        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("the");

        throw new IllegalArgumentException("the exception ");
    }

    @BeforeClass
    public static void executaUnCopPerClasseAbansdeQualsevolTest(){
        System.out.println("Abans d'executar qualsevol test, un cop per classe");
    }

    @AfterClass
    public static void executaUnCopDespresDeQualsevolTest(){
        System.out.println("Despres d'executar qualsevol test, un cop per classe");
    }

    @Before
    public void executaAbansDeCadaTest(){

        System.out.println("Abans d'executar qualsevol test, per a CADA TEST!");
    }

    @After
    public void executaDespresDeCadaTest(){
        System.out.println("Despres d'executar qualsevol test, per a CADA test!");

    }

    @Test
    public void assercionsDeJUNIT(){

        assertEquals(5, 2+3);
        assertFalse("fals es fals", false);
        assertFalse(3 > 5);
        assertTrue(5 > 3);

        int[] finsA10 = {1,2,3,4,5,6,7,8,9,10};
        int [] primers10 = {2,1,3,5,4,6,8,7,9,10};

        Arrays.sort(primers10);
        assertArrayEquals(finsA10,primers10);

        assertNotNull("Un string buit NO es null", "");
        assertNotNull("");

        assertNotSame("Un string buit no es NULL", "", null);
        assertNotSame("", null);

        assertNull("Nomes null es considerat Null", null);

        Object obj = null;
        assertSame(obj, null);
    }
    @Test
    public void assertThatAmbHamCrest(){
        assertThat("testejant que 4+5 son 9", 4+5, is(9));
        assertThat("fals es fals", false, equalTo(false));
        assertThat(false,is(false));
        assertThat("true es true", true, equalTo(true));
        assertThat(true,is(true));

        assertThat("Un string buit no es null", is(not(nullValue() ) ));
        assertThat("Aixo es un text", containsString("un"));
        assertThat("Aixo es un text", endsWith("xt"));
        assertThat("Aixo es un text", startsWith("Ai"));
    }
}
