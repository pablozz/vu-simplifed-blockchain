package blockchain.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {

    private static final int HASH_LENGTH = 64;

    public static String getHash(String input) {
        int hashInt = 0;

        for (int inputElem : input.toCharArray()) {
            hashInt = stirChar(hashInt, inputElem);
        }

        StringBuilder hashBuilder = new StringBuilder(Integer.toHexString(hashInt));

        while (hashBuilder.length() != HASH_LENGTH) {
            for (int hashElem : hashBuilder.toString().toCharArray()){
                hashInt = stirChar(hashInt, hashElem);

                hashBuilder.append(Integer.toHexString(hashInt));
            }

            int hashLength = hashBuilder.length();
            if (hashLength > HASH_LENGTH) {
                hashBuilder.delete(HASH_LENGTH, hashLength);
            }
        }

        return  hashBuilder.toString();
    }

    private static int stirChar(int hashInt, int elem) {
        hashInt += Math.pow(elem, 3);
        hashInt += ~elem % ~hashInt;
        hashInt += hashInt << ~hashInt << 1;

        return hashInt;
    }

    public static String getSHA256Hash(String input) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (md != null) {
            md.update(input.getBytes());
        }

        byte[] digest = new byte[0];

        if (md != null) {
            digest = md.digest();
        }

        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }

        return sb.toString();
    }
}