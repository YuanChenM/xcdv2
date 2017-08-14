package com.framework.number.generate.bean.param;

/**
 * Created by jackjiang on 16/11/18.
 */
public class SequenceParam extends GenerateParam {
    /**是否有占位符*/
    private boolean placeholder;

    private String padChar = "0";

    public String getPadChar() {
        return padChar;
    }

    public void setPadChar(String padChar) {
        this.padChar = padChar;
    }

    public boolean isPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(boolean placeholder) {
        this.placeholder = placeholder;
    }
}
