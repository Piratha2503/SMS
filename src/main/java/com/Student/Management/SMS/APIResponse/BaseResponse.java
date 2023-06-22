package com.Student.Management.SMS.APIResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse
{
    private String status,code,message;

    public BaseResponse(String code,String status,String message)
    {
      this.code = code;
      this.status = status;
      this.message = message;
    }

}
