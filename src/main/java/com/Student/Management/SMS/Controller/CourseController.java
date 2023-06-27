package com.Student.Management.SMS.Controller;

import com.Student.Management.SMS.Entity.Course;
import com.Student.Management.SMS.RequestDTO.CourseRequest;
import com.Student.Management.SMS.RequestDTO.StudentRequest;
import com.Student.Management.SMS.ResponseDTO.CourseResponse;
import com.Student.Management.SMS.Services.CourseServices;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseServices courseServices;

    @PostMapping("/insertfile")
    public String uploadExcelFile(@RequestParam("file") MultipartFile file) throws IOException
    {
       try
        {
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet)
            {
                CourseResponse courseResponse = new CourseResponse();
                if (row.getRowNum() == 0) continue;
                courseResponse.setCoursename(row.getCell(0).getStringCellValue());
                courseResponse.setCategory(row.getCell(1).getStringCellValue());
                courseServices.insertCourse(courseResponse);
            }

        }
        catch (IOException e) {e.printStackTrace();}

       return "kok";
    }
}
    /*
    @PostMapping("/insertCourse")
    public void insert(@RequestBody CourseRequest courseRequest)
    {
        courseServices.insertCourse(courseRequest);
    }
    @GetMapping("/getByCID/{id}")
    public Course getById(@PathVariable Long id)
    {
        return courseServices.getByCourseId(id);
    }

     */

