package com.Student.Management.SMS.RestEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ResponseStatus
{
    SUCCESS("success"),
    FAILURE("failure"),
    UNKNOWN("unknown"),
    ERROR("error"),
    WARNING("warning");

    private String status;

    ResponseStatus(String status){this.status = status;}

    public static ResponseStatus getByStatus(String status)
    {
        for (ResponseStatus responseStatus : values())
        {
            if (responseStatus.getStatus().equals(status)) {return responseStatus;}
        }
        throw new AssertionError("Request status not found for given status [status: " + status + "]");
    }


}
