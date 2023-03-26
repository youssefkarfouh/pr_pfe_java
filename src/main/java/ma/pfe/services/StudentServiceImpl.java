package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.mappers.StudentMapper;
import ma.pfe.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepository repository;
    private StudentMapper mapper;

    public StudentServiceImpl(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public StudentDto save(StudentDto dto) {
        LOGGER.debug("start methode save in service");

        return mapper.convertToDto(repository.save(mapper.convertToEntity(dto)));
    }

    @Override
    public Long update(StudentDto dto) {
        LOGGER.debug("start methode update in service");

        return mapper.convertToDto(repository.save(mapper.convertToEntity(dto))).getId();

    }

    @Override
    public Boolean deleteById(Long id) {
        LOGGER.debug("start methode deleteById in service");
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<StudentDto> selectAll() {

        LOGGER.debug("start methode selectAll in service");
        return mapper.convertToDtos(repository.findAll());
    }
}
