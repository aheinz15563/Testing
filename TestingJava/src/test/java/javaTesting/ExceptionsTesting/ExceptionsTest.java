package javaTesting.ExceptionsTesting;

import org.junit.Test;

import java.sql.SQLOutput;

import static org.junit.Assert.assertEquals;

public class ExceptionsTest {

    @Test (expected = NullPointerException.class)
    public void NullPointerTest(){

        Integer edat = null;
        String edatEnLletres = edat.toString();

        assertEquals("" + 18, edatEnLletres);

    }

    @Test
    public void catchNullPointerTest(){

        Integer edat = null;
        String edatEnLletres;

        try {
            edatEnLletres = edat.toString();
        } catch (NullPointerException npe){
            edat = 18;
            edatEnLletres = edat.toString();
        }

        assertEquals("" + 18, edatEnLletres);

    }

    @Test
    public void TrycatchNullPointerTest(){

        String text;
        Integer edat = null;
        String edatEnLletres = "";

        try {
            edatEnLletres = edat.toString();
        } catch (NullPointerException npe){
            edat = 18;
            edatEnLletres = edat.toString();
        } finally {
            text = "Edat == " + edatEnLletres;
        }

        assertEquals("Edat == 18", text);

    }

    @Test (expected = IllegalArgumentException.class)
    public void throwingIllegalArgumentExceiptionTrycatchNullPointerTest(){

        String text;
        Integer edat = null;
        String edatEnLletres = "";

        try {
            System.out.println("Pas 1: Generam NullPointerException");
            edatEnLletres = edat.toString();
        } catch (NullPointerException npe){
            System.out.println("Pas 2: Capturam la NullPointerException");
            System.out.println("Pas 3: Anam a llançar una excepcio");
            throw new IllegalArgumentException("Excepcio creada i llancada per mi");
        } finally {
            System.out.println("Pas final: Codi de tancament");
        }
    }

    @Test (expected = NullPointerException.class)
    public void excepcioErronia(){
        String text;
        Integer edat = null;
        String edatEnLletres = "";

        try {
            System.out.println("Pas 1: Generam NullPointerException");
            edatEnLletres = edat.toString();
            throw new IllegalArgumentException("Excepcio creada i llancada per mi");

        } catch (NullPointerException npe){
            System.out.println("Pas 2: Capturam la NullPointerException");

        } finally {
            System.out.println("Pas final: Codi de tancament");
        }
    }

    @Test
    public void jugantAmbObjecteExcepcioTest(){

        Integer edat = null;
        String edatEnLletres;

        try {
            edatEnLletres = edat.toString();
        } catch (NullPointerException npe){
            edat = 18;
            edatEnLletres = edat.toString();
            System.out.println("Anem a jugar amb l'objecte Excepcio !!!");

            System.out.println(npe.getMessage());
            System.out.println(npe.getStackTrace());
            npe.printStackTrace();
        }

        assertEquals("" + 18, edatEnLletres);

    }


}
