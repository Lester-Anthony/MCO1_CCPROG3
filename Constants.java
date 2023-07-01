/**
 * The Constants class provides constants used throughout the application.
 */
public class Constants {

    /**
     * Constructs a Constants object.
     */
    public Constants(){}

    /**
     * The maximum number of items allowed.
     */
    public static final int MAX_ITEMS = 24;

    /**
     * The spacer used for indentation or formatting purposes.
     */
    public final String SPACER = "    ";

    // COLORED TEXT FORMATTING
    
    /**
     * The ANSI escape code for resetting text color to default.
     */
    public final String RST = "\u001B[0m";

    /**
     * The ANSI escape code for setting text color to red.
     */
    public final String RED = "\u001B[91m";

    /**
     * The ANSI escape code for setting text color to green.
     */
    public final String GRN = "\u001B[32m";

    /**
     * The ANSI escape code for setting text color to blue.
     */
    public final String BLU = "\u001B[34m";

    /**
     * The ANSI escape code for setting text color to yellow.
     */
    public final String YLW = "\033[0;33m";
}
