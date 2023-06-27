package com.Student.Management.SMS.Controller;

import com.Student.Management.SMS.APIResponse.BaseResponse;
import com.Student.Management.SMS.APIResponse.ContentResponse;
import com.Student.Management.SMS.APIResponse.TempRes;
import com.Student.Management.SMS.Entity.Student;
import com.Student.Management.SMS.RequestDTO.StudentRequest;
import com.Student.Management.SMS.RestEnum.ResponseStatus;
import com.Student.Management.SMS.Services.StudentServices;
import com.Student.Management.SMS.utils.Constants;
import com.Student.Management.SMS.utils.ValidationResponses;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.*;

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
    public ResponseEntity<Object> insert(@RequestParam(value = "file", required = false) MultipartFile file,
                                         @RequestBody StudentRequest studentRequest) throws IOException {


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



/*
@PostMapping("/insertfile")
    public String readExcelFile(@RequestParam("file") MultipartFile file) throws IOException
    {
        //BufferedReader myreader = new BufferedReader(new InputStreamReader());
            Workbook workbook = new XSSFWorkbook(file.getInputStream());

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
                 Workbook workbook = new XSSFWorkbook(String.valueOf(reader)))
            {
                Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read from the first sheet
                for (Row row : sheet)
                {
                    for (Cell cell : row)
                    {
                        CellType cellType = cell.getCellType();
                        if (cellType == CellType.STRING)
                        {
                            cell.getStringCellValue();
                            return "jik";
                            // Process the string cell value as needed
                        }

                        // Handle other cell types if required
                    }
                }

            }

            catch (IOException e)
            {
                e.printStackTrace();
            }
            return "jiji";
        }
   }

 */
