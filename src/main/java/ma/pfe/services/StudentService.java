package ma.pfe.services;

import ma.pfe.dtos.StudentDto;

import java.util.List;

public interface StudentService {

    Long save(StudentDto s);

    Long update(StudentDto s);

    Boolean deleteById(Long id);

    List<StudentDto> selectAll();
}
