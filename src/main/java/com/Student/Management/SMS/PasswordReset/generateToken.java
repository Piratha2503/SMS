package com.Student.Management.SMS.PasswordReset;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@Component
public class generateToken
{

    public String tokenGenerate()
    {
        Date date = new Date();
        Claims claims = Jwts.claims().setIssuer("Pirathaban").setIssuedAt(date);
        return Jwts.builder().setClaims(claims).compact();
    }

}
