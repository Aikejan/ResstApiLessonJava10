package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.Student;
import peaksoft.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentApi {

    private  final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @PostMapping
    public  Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }


    @GetMapping("/{studentId}")
    public  Student getById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }
}
