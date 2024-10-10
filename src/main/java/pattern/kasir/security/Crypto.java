package pattern.kasir.security;

import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.engines.AESLightEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

public class Crypto {

  //    private static final String defaultKey = "12fc5e5b5abe431b94870823a154e511d2e3419f47c455a9659d89268776a3eb";
  //    private static final String defaultKey = "7bf29d8a22a03f43baf953f5c5e4cb264dbf2db3651da21d28daee478a189cce";
  private static final String defaultKey =
    "2d38e01c52c0d9c475dac174eff7cea6464778ec35f3d78eba5c1421d684a3e6";

  public static String performEncrypt(String keyText, String plainText) {
    try {
      byte[] key = Hex.decode(keyText.getBytes());
      byte[] ptBytes = plainText.getBytes();
      BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(
        new CBCBlockCipher(new AESLightEngine())
      );
      cipher.init(true, new KeyParameter(key));
      byte[] rv = new byte[cipher.getOutputSize(ptBytes.length)];
      int oLen = cipher.processBytes(ptBytes, 0, ptBytes.length, rv, 0);
      cipher.doFinal(rv, oLen);
      return new String(Hex.encode(rv));
    } catch (Exception e) {
      return "Error";
    }
  }

  public static String performEncrypt(String cryptoText) {
    return performEncrypt(defaultKey, cryptoText);
  }

  public static String performDecrypt(String keyText, String cryptoText) {
    try {
      byte[] key = Hex.decode(keyText.getBytes());
      byte[] cipherText = Hex.decode(cryptoText.getBytes());
      BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(
        new CBCBlockCipher(new AESLightEngine())
      );
      cipher.init(false, new KeyParameter(key));
      byte[] rv = new byte[cipher.getOutputSize(cipherText.length)];
      int oLen = cipher.processBytes(cipherText, 0, cipherText.length, rv, 0);
      cipher.doFinal(rv, oLen);
      return new String(rv).trim();
    } catch (Exception e) {
      return "Error";
    }
  }

  public static String performDecrypt(String cryptoText) {
    return performDecrypt(defaultKey, cryptoText);
  }

  public static void main(String[] args) {
    String strToEncrypt = "paul"; //put text to encrypt in here
    String encryptionResult = new Crypto().performEncrypt(strToEncrypt);
    System.out.println("Encryption Result : " + encryptionResult);

    String strToDecrypt = "a52ed7a180d5255c1652bdaa90782f0a"; //put text to decrypt in here
    String decriptionResult = new Crypto().performDecrypt(strToDecrypt);
    System.out.println("Decryption Result : " + decriptionResult);
  }
}
