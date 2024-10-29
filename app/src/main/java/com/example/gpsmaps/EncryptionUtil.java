package com.example.gpsmaps;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class EncryptionUtil {

    // Genera una clave de cifrado AES de 256 bits y encripta los datos
    public static byte[] encryptData(String data) throws Exception {
        // Inicializa el generador de claves AES con un tamaño de 256 bits
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256, new SecureRandom());
        SecretKey secretKey = keyGen.generateKey();

        // Crea una instancia del cifrador AES y lo inicializa en modo de encriptación
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Convierte los datos de texto a bytes y los encripta
        return cipher.doFinal(data.getBytes());
    }

    // Método de utilidad que convierte una clave de bytes a un formato SecretKey (para descifrar en el futuro si se necesita)
    public static SecretKeySpec getSecretKeySpec(byte[] keyBytes) {
        return new SecretKeySpec(keyBytes, "AES");
    }
}