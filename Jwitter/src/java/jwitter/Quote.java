/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jwitter;

/**
 *
 * @author sarzy0021
 */
public class Quote {
    public static String[] quotes = {
        "I like to Jwitt !",
        "Jwitting is a pleasure for the tips",
        "Jwitting procures pleasure",
        "Show me your tongue !",
        "VisualWebJSF is a fucking crap !"};

    public static String getRandomQuote() {
        return quotes[(int)(Math.random() * quotes.length)];
    }
}
