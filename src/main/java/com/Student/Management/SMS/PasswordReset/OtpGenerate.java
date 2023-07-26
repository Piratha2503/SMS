package com.Student.Management.SMS.PasswordReset;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;


@Getter
@Setter
public class OtpGenerate
{
    private int otp;
    Random random = new Random();
    int myotp = random.nextInt(999999);

    public String getOtp()
    {
        this.otp = this.myotp;
        return Integer.toString(otp);
    }
}
