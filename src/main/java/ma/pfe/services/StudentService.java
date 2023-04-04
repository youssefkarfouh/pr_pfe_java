package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.dtos.StudentIdDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Long save(StudentDto s);

    Long update(StudentDto s);

    Boolean deleteById(StudentIdDto idcomp);

    List<StudentDto> selectAll();

    StudentDto selectById(StudentIdDto copositKey);
}
