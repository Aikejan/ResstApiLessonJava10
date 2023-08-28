package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.Student;

import java.util.List;
@Service
public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Long id, Student student);
    String deleteStudent(Long id);
}
