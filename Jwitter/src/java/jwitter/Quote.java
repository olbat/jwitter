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
        "VisualWebJSF is a fucking crap !",
        "Might I ask you where do you keep the SPOOOOONS ?",
        "Hubert Cumberdale you taste like soot and poo !",
        "I thought you were out fighting the great war",
        "JSP Owns! Erm, or not ...",
        "I'm ugly",
        "I like rusty spoons",
        "The feeling of rust ... is almost orgasmic.",
        "Hello there little child",
        "I'm here to enquire about your spoons",
        "I wonder what you taste like"};

    public static String getRandomQuote() {
        return quotes[(int)(Math.random() * quotes.length)];
    }
}
