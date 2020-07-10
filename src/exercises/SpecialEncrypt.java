package exercises;


public class SpecialEncrypt {
    private static char encryptCharacter(char character1, char character2) {
        char encodedCharacter = (char)((character1 ^ (character2 & 0x1F)));
        return (int) character1 > 31 ? encodedCharacter : character1;
    }

    public static String specialEncryptor(String text, String key) {
        StringBuilder encodedText = new StringBuilder();
        if (key.equals("")) {
            key = null;
        }
        int index = 0;
        assert key != null;
        char[] keyArray = key.toCharArray();
        for (char ch : text.toCharArray()) {
            char newKey = keyArray[index % key.length()];
            char encodedCharacter = encryptCharacter(ch, newKey);
            int chAsBinary = Integer.parseInt(Integer.toBinaryString(ch));
            int keyAsBinary = Integer.parseInt(Integer.toBinaryString((int)newKey & 0x1F));
            int encodedCharacterAsBinary = Integer.parseInt(Integer.toBinaryString(encodedCharacter));
            System.out.printf("%08d (%c) ^ %08d (%c) = %08d (%c)%n", chAsBinary, ch, keyAsBinary, newKey, encodedCharacterAsBinary, encodedCharacter);
            encodedText.append((int) encodedCharacter < 32 || (int) encodedCharacter >= 127 ? ch : encodedCharacter);
            index++;
        }
        return encodedText.toString();
    }

    public static void main(String[] args) {
        String aString = "This is some text";
        String aKey = "test!!";
        String encodedString =  specialEncryptor(aString, aKey);
        System.out.println(aString);
        System.out.println(encodedString);
        System.out.println(specialEncryptor(encodedString, aKey));
    }
}
