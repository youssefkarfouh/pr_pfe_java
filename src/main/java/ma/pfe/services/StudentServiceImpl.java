package ma.pfe.services;

import ma.pfe.dtos.StudentIdDto;
import ma.pfe.entities.StudentEntity;
import ma.pfe.mappers.StudentMapper;
import ma.pfe.dtos.StudentDto;
import ma.pfe.repositories.StudentRepository;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("service1")
public class StudentServiceImpl implements StudentService {
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;
    private final StudentMapper mapper = Mappers.getMapper(StudentMapper.class);

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    @Override
    public Long save(StudentDto dto) {
        LOGGER.debug("start method save dto in service : {} ", dto);
        StudentDto s_dto = mapper.studentEntityToDto(studentRepository.save(mapper.StudentDtoToEntity(dto)));
        return s_dto.getStudentId().getId();
    }

    @Override
    public Long update(StudentDto dto) {
        LOGGER.debug("start method save dto : {} ", dto);
        StudentDto s_dto = mapper.studentEntityToDto(studentRepository.save(mapper.StudentDtoToEntity(dto)));
        return s_dto.getStudentId().getId();
    }

    @Override
    public Boolean deleteById(StudentIdDto idcomp) {
        LOGGER.debug("start method delete id : {} ", idcomp);
        studentRepository.deleteById(mapper.studentIdDTOToStudentId(idcomp));
        return true;
    }

    @Override
    public List<StudentDto> selectAll() {
        LOGGER.debug("start method select All");

        return mapper.studentEntiesToDtos(studentRepository.findAll());
    }

    @Override
    public StudentDto selectById(StudentIdDto copositKey) {

        Optional s_entity = studentRepository.findById(mapper.studentIdDTOToStudentId(copositKey));

        return mapper.studentEntityToDto((StudentEntity) s_entity.orElse(null));
    }
}
