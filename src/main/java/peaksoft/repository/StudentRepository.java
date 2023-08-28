package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
