package main.java.models;

public class Symbol {

    private char symbolChar;

    private String avatorUrl;

    public Symbol(char symbolChar, String avatorUrl) {
        this.symbolChar = symbolChar;
        this.avatorUrl = avatorUrl;
    }

    public char getSymbolChar() {
        return symbolChar;
    }

    public void setSymbolChar(char symbolChar) {
        this.symbolChar = symbolChar;
    }

    public String getAvatorUrl() {
        return avatorUrl;
    }

    public void setAvatorUrl(String avatorUrl) {
        this.avatorUrl = avatorUrl;
    }
}
