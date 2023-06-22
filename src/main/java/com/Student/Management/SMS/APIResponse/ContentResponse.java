package com.Student.Management.SMS.APIResponse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.datasource.JdbcTransactionObjectSupport;

import javax.xml.stream.events.DTD;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ContentResponse<T> extends BaseResponse
{
    private Map<String,T> contents = new HashMap<>();

    public ContentResponse(String key,T dto,String code,String status,String message)
    {
       super(code,status,message);
        contents.put(key,dto);
    }
}
