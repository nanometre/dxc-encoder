public class Encoder {
    private static final String charOrder = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";

    public static String encode(String plainText){
        if (!charOrder.contains(Character.toString(plainText.charAt(0)))) {
            return plainText;
        } else {
            int shift = charOrder.indexOf(plainText.charAt(0));
            String encodedText = Character.toString(plainText.charAt(0));
            int length = plainText.length();

            for (int i = 1; i < length; i++) {
                char ch = plainText.charAt(i);
                if (ch != 32) {
                    int newIndex = charOrder.indexOf(ch) - shift;
                    if (newIndex < 0) {
                        encodedText += charOrder.charAt(newIndex + 44);
                    } else {
                        encodedText += charOrder.charAt(newIndex);
                    }
                } else {
                    encodedText += ch;
                }
            }
            return encodedText;
        }
    }

    public static String decode(String encodedText) {
        if (!charOrder.contains(Character.toString(encodedText.charAt(0)))) {
            return encodedText;
        } else {
            int shift = charOrder.indexOf(encodedText.charAt(0));
            String decodedText = "";
            int length = encodedText.length();

            for (int i = 1; i < length; i++) {
                char ch = encodedText.charAt(i);
                if (ch != 32) {
                    int newIndex = charOrder.indexOf(ch) + shift;
                    if (newIndex > 44) {
                        decodedText += charOrder.charAt(newIndex - 44);
                    } else {
                        decodedText += charOrder.charAt(newIndex);
                    }
                } else {
                    decodedText += ch;
                }
            }
            return decodedText;
        }
    }

    public static void main(String[] args){
        String text = "BHELLO WORLD";
        String encoded = encode(text);
        System.out.println(encoded);

        String text1 = "$HELLO WORLD";
        String encoded1 = encode(text1);
        System.out.println(encoded1);

        String encodedText = "FC/GGJ RJMG.";
        String decoded = decode(encodedText);
        System.out.println(decoded);

        String encodedText1 = "$C/GGJ RJMG.";
        String decoded1 = decode(encodedText1);
        System.out.println(decoded1);
    }
}
