package JavaTestingResources;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class PasswordUtils {

    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ACBDEFG"; // aixo hauria de ser mes llarg.

    public static String genSalt (){

        return genSalt(8);
    }
    public static String genSalt (int length){

        StringBuilder valor = new StringBuilder(length);

        for(int k = 0; k < length; k++){
            valor.append(ALPHABET.charAt( RANDOM.nextInt (ALPHABET.length()) ) );
        }

        return valor.toString();
    }

    public static String genSecurePassword (String password, String salt) {
        String result = null;

        hashedPassword(password , salt);

        return result;
    }

    public static String hashedPassword ( String password, String salt) {
        MessageDigest md;
        String result = "";

        try {

            md = MessageDigest.getInstance("SHA-256");
            md.update((password + salt).getBytes());
            result = new String (md.digest() );

        } catch ( NoSuchAlgorithmException nase){

            System.out.println("Algoritme de hash erroni");
            System.exit(1);
        }
        return result;
    }

    public static boolean verifyUserPassword (String passwordEntered, String userSalt, String securePassword) {

        return securePassword.equals(hashedPassword(passwordEntered,userSalt));

    }
}
