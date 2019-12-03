package com.uniajc.diplomado.services.document.dto;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.dto
 * Shaft
 *  *
 * the name of the current project
 */
public class Message
{
    private String message;

    public Message (String message) {
        this.message = message;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }
}
