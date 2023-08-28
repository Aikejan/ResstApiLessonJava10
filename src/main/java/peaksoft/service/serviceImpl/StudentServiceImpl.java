package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.Student;
import peaksoft.repository.StudentRepository;
import peaksoft.service.StudentService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {

        return studentRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException("Student with id" + id + "Is not found")
        );
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student student1 = studentRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException("Student with id" + id + "Is not found")
        );
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setEmail(student.getEmail());
        return student;
    }

    @Override
    public String deleteStudent(Long id) {
        if(!studentRepository.existsById(id)){
            throw  new NoSuchElementException("Student with id" + id + "Is not found");
        }
        studentRepository.deleteById(id);
        return "Student with id" + id + "Is not found";
    }
}
