package com.todo_app.utils;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public class PasswordHashing {
	private static final Random random = new Random();
    private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int iterations = 10000;
    private static final int keylength = 256;
    /* Method to generate the salt value. */
    /* Method to generate the salt value. */
    public static String getSaltvalue(int length){
        StringBuilder finalVal = new StringBuilder(length);
        for(int i=0; i< length; i++){
            finalVal.append(characters.charAt(random.nextInt(characters.length())));
            

        }
        return new String(finalVal);

    }
    /* Method to generate the hash value */
    public static byte[] hash(char[] password, byte[] salt){
        PBEKeySpec spec = new PBEKeySpec(password,salt,iterations,keylength);
        Arrays.fill(password, Character.MIN_VALUE);
        try{
            SecretKeyFactory skf =  SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            
            return  skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        finally
        {
            spec.clearPassword();
        }

    }
    /* Method to encrypt the password using the original password and salt value. */
    public static String generateSecurePassword(String password, String salt){
        String finalVal = "";
        byte[] securePassword = hash(password.toCharArray(),salt.getBytes());
     
        finalVal = Base64.getEncoder().encodeToString(securePassword);
        return finalVal;
    }
    /* Method to verify if both password matches or not */
    public static boolean verifyUserPassword(String providedPassword,
                                             String securedPassword, String salt)
    {
        boolean finalval = false;

        /* Generate New secure password with the same salt */
        String newSecurePassword = generateSecurePassword(providedPassword, salt);

        /* Check if two passwords are equal */
        finalval = newSecurePassword.equalsIgnoreCase(securedPassword);

        return finalval;
    }
}
