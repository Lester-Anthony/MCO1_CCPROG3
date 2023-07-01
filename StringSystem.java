/**
 * The StringSystem class provides methods for manipulating strings.
 */
public class StringSystem {
    
    /**
     * Constructs a StringSystem object.
     */
    public StringSystem(){}

    /**
     * Centers a string within a given width.
     *
     * @param text        the text to be centered
     * @param totalWidth  the total width of the resulting string
     * @return the centered string
     */
    public String centerString(String text, int totalWidth) {
        int textLength = text.length();
        
        if (totalWidth <= textLength) {
            return text;
        }
        else {
            int padding = (totalWidth - textLength) / 2;
            String centeredText = String.format("%" + padding + "s%s%" + padding + "s", "", text, "");
            return centeredText;
        }
    }
}
