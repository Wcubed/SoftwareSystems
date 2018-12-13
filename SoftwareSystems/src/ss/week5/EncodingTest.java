package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
    	// ---- Hex ----
    	
        String input = "Hello Big World";

        System.out.println(Hex.encodeHexString(input.getBytes()));
        
        byte[] outputHex = Hex.decodeHex("48656c6c6f20576f726c64");
        System.out.println(new String(outputHex));
        
        // ---- Base64 ----
        
        input = "Hello World";

        System.out.println(Base64.encodeBase64String(input.getBytes()));
        
        byte[] output64 = Base64.decodeBase64("SGVsbG8gV29ybGQ=");
        System.out.println(new String(output64));
        
        // ---- Comparison ----
        
        input = "010203040506";
        System.out.println(Base64.encodeBase64(Hex.decodeHex("48656c6c6f20576f726c64")));
        
        // ----
        
        System.out.println(new String(Base64.decodeBase64("U29mdHdhcmUgU3lzdGVtcw==")));
        
        // ----
        
        System.out.println(Base64.encodeBase64String("a".getBytes()));
        System.out.println(Base64.encodeBase64String("aa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaaa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaaaa".getBytes()));
        System.out.println(Base64.encodeBase64String("aaaaaa".getBytes()));
    }
}
