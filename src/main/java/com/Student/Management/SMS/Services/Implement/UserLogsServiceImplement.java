package com.Student.Management.SMS.Services.Implement;

import com.Student.Management.SMS.Repository.UserLogsRepository;
import com.Student.Management.SMS.Services.UserLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLogsServiceImplement implements UserLogsService {
    @Autowired
    private UserLogsRepository userLogsRepository;

    @Override
    public boolean existsByToken(String token) {
        return userLogsRepository.existsByToken(token);
    }
}
