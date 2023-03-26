package ma.pfe.services;

import ma.pfe.dtos.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto save(StudentDto dto);
    Long update(StudentDto dto);
    Boolean deleteById(Long id);
    List<StudentDto> selectAll();
}
