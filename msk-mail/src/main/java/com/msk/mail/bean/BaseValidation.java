package com.msk.mail.bean;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jackjiang on 16/8/2.
 */
public abstract class BaseValidation<T> {
    private List<String> errorMessageList = new ArrayList<>();
    private static String MAIL_REGEX = "^([a-z0-9A-Z]+[-_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public boolean hasErrors(){
        return !CollectionUtils.isEmpty(errorMessageList);
    }

    public String getAllErrorMessage(){
        StringBuffer errorMessage = new StringBuffer();

        if(StringUtils.isEmpty(errorMessageList)){
            return errorMessage.toString();
        }

        for (String message : errorMessageList){
            errorMessage.append(message+"\n");
        }

        return errorMessage.toString();
    }
    /**
     * Check the mail address.
     *
     * @param mail mail address
     * @return check result (true is check ok)
     */
    public static boolean checkMail(String mail) {
        return checkRegex(MAIL_REGEX, mail);
    }
    public static boolean checkRegex(String regex, String value) {
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(value);
        return mat.find();
    }

    public void addErrorMessage(String message){
        this.errorMessageList.add(message);
    }

    public abstract void validation(T entity);

}
