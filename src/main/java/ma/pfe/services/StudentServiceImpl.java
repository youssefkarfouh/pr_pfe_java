package ma.pfe.services;

import ma.pfe.mappers.StudentMapper;
import ma.pfe.dtos.StudentDto;
import ma.pfe.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("service1")
public class StudentServiceImpl implements StudentService {
    private final static Logger LOGGER= LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepository studentRepository;
    private StudentMapper mapper;

    public StudentServiceImpl( StudentRepository studentRepository,StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.mapper = studentMapper;
    }

    @Override
    public Long save(StudentDto dto) {
        LOGGER.debug("start method save dto in service : {} ",dto);
        StudentDto s_dto = mapper.studentEntityToDto(studentRepository.save(mapper.StudentDtoToEntity(dto)));
        return s_dto.getId();
    }

    @Override
    public Long update(StudentDto dto) {
        LOGGER.debug("start method save dto : {} ",dto);
        StudentDto s_dto = mapper.studentEntityToDto(studentRepository.save(mapper.StudentDtoToEntity(dto)));
        return s_dto.getId();
    }

    @Override
    public Boolean deleteById(Long id) {
        LOGGER.debug("start method delete id : {} ",id);
        studentRepository.deleteById(id);
        return true;
    }

    @Override
    public List<StudentDto> selectAll() {
        LOGGER.debug("start method select All");
        return mapper.studentEntiesToDtos(studentRepository.findAll());
    }
}
