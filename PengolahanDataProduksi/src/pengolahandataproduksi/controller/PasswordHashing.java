package pengolahandataproduksi.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class PasswordHashing {

    Map<String, String> YA = new HashMap<>();
    private String salt = "ya-salt-text";

    public PasswordHashing() {
    }

    public PasswordHashing(String salt) {
        this.salt = salt;
    }

    public String getHashedPassword(String password) {
        if (password.isEmpty()) {
            return null;
        }
        return generateHash(salt + password);
    }

    private void signup(String username, String password) {
        String saltedPassword = salt + password;
        String hashedPassword = getHashedPassword(password);
        YA.put(username, hashedPassword);
    }

    private Boolean checking(String username, String password){
        String storedPasswordHash = YA.get(username);
        String hashedPassword = getHashedPassword(password);
        return hashedPassword.equals(storedPasswordHash);
    }
    
    private static String generateHash(String input) {
        StringBuilder hash = new StringBuilder();
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] hashedByte = sha.digest(input.getBytes());
            char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
            for (int idx = 0; idx < hashedByte.length; ++idx) {
                byte b = hashedByte[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }

        } catch (NoSuchAlgorithmException e) {

        }
        return hash.toString();
    }
    
    public static void main(String args[]) {

    }
    

}
