package com.Student.Management.SMS.Controller;

import com.Student.Management.SMS.APIResponse.BaseResponse;
import com.Student.Management.SMS.APIResponse.ContentResponse;
import com.Student.Management.SMS.Entity.Student;
import com.Student.Management.SMS.RequestDTO.StudentRequest;
import com.Student.Management.SMS.RestEnum.ResponseStatus;
import com.Student.Management.SMS.Services.StudentServices;
import com.Student.Management.SMS.utils.Constants;
import com.Student.Management.SMS.utils.ValidationResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
public class StudentController
{
    @Autowired
    private StudentServices studentServices;
    @Autowired
    private ValidationResponses validationResponses;

    //Search Function with Validation
    @GetMapping("/findStudent")
    public ResponseEntity<Object> searchByNic(@RequestParam(name = "nic", required = false) String nic,
                                              @RequestParam(name = "stuid",required = false) String stuid)
    {
            if (!(nic == null))
            {
                if (!studentServices.isExistByNic(nic)) return ResponseEntity.ok(new BaseResponse(
                        validationResponses.getCommonFailureCode(),
                        ResponseStatus.UNKNOWN.getStatus(),
                        validationResponses.getNicNotFoundMsg()));
                return ResponseEntity.ok(new ContentResponse<>(
                        Constants.STUDENTS,
                        studentServices.findByNic(nic),
                        validationResponses.getCommonSuccessCode(),
                        ResponseStatus.SUCCESS.getStatus(),
                        validationResponses.getViewAllMsg()));
            }
            if (!(stuid == null)) {
                if (!studentServices.isExistByStuid(stuid))
                    return ResponseEntity.ok(new BaseResponse(
                            validationResponses.getCommonSuccessCode(),
                            ResponseStatus.FAILURE.getStatus(),
                            validationResponses.getSTUIDNotFoundMsg()));

                return ResponseEntity.ok(new ContentResponse<>(Constants.STUDENTS,
                        studentServices.findByStuid(stuid),
                        validationResponses.getCommonSuccessCode(),
                        ResponseStatus.SUCCESS.getStatus(),
                        validationResponses.getViewAllMsg()));
            }
            return ResponseEntity.ok(new ContentResponse<>(
                    Constants.STUDENTS,
                    studentServices.getAllStudents(),
                    validationResponses.getCommonSuccessCode(),
                    ResponseStatus.SUCCESS.getStatus(),
                    validationResponses.getViewAllMsg()));



    }




    // CRUD Operations & Validations
    @PostMapping("/insertStudent")
    public ResponseEntity<Object> insert(@RequestBody StudentRequest studentRequest)
    {
        if (studentServices.isExistByNic(studentRequest.getNic()))
        return ResponseEntity.ok(new BaseResponse(validationResponses.getCommonFailureCode(),
                ResponseStatus.ERROR.getStatus(),
                validationResponses.getNicAlreadyExist()
                ));
         studentServices.insertSudents(studentRequest);
        return ResponseEntity.ok(new BaseResponse(validationResponses.getCommonSuccessCode(),
                ResponseStatus.SUCCESS.getStatus(),
                validationResponses.getInsertMsg()
        ));

    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Object> update(@RequestBody StudentRequest studentRequest)
    {
        if (studentServices.isExistByNic(studentRequest.getNic()))
        return ResponseEntity.ok(new BaseResponse(validationResponses.getCommonFailureCode(),
            ResponseStatus.ERROR.getStatus(),
            validationResponses.getNicAlreadyExist()
    ));
        if (!studentServices.isExistByNic(studentRequest.getNic()))
            return ResponseEntity.ok(new BaseResponse(validationResponses.getCommonFailureCode(),
            ResponseStatus.ERROR.getStatus(),
            validationResponses.getNicNotFoundMsg()
    ));
        studentServices.updateStudent(studentRequest);
        return ResponseEntity.ok(new BaseResponse(validationResponses.getCommonSuccessCode(),
            ResponseStatus.SUCCESS.getStatus(),
            validationResponses.getUpdateMsg()
    ));
    }

    @DeleteMapping("/deleteStudent/{nic}")
    public ResponseEntity<Object> deleteStudent(@PathVariable String nic)
    {
        if (studentServices.isExistByNic(nic))
        {
            studentServices.deleteStudent(nic);
            return ResponseEntity.ok(new BaseResponse
                    (
                    validationResponses.getCommonSuccessCode(),
                    ResponseStatus.SUCCESS.getStatus(),
                    validationResponses.getDeleteMsg()
                    ));
        }
        return ResponseEntity.ok(new BaseResponse
                (
                   validationResponses.getCommonFailureCode(),
                   ResponseStatus.ERROR.getStatus(),
                   validationResponses.getNicNotFoundMsg()
                ));
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<Object> getALlPage(Pageable pageable)
    {

        return ResponseEntity.ok(new ContentResponse<>(
                Constants.STUDENTS,
                studentServices.getALlPage(pageable),
                validationResponses.getCommonSuccessCode(),
                ResponseStatus.SUCCESS.getStatus(),
                validationResponses.getViewAllMsg()));
    }





}
