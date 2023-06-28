public class StringSystem {
    
    public StringSystem(){};

    public String centerString(String text, int totalWidth) {
        int textLength = text.length();
        
        if (totalWidth <= textLength) {
            return text;
        } else {
            int padding = (totalWidth - textLength) / 2;
            String centeredText = String.format("%" + padding + "s%s%" + padding + "s", "", text, "");
            return centeredText;
        }
    }
}
