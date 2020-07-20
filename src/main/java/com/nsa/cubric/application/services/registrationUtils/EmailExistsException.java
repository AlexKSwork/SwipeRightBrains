package com.nsa.cubric.application.services.registrationUtils;
//Simple class exceptioni to show if the email still exists (created previously)
public class EmailExistsException extends Exception {
    public EmailExistsException(String errorMessage){
        super(errorMessage);
    }
}
