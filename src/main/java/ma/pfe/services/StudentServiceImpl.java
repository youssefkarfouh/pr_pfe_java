package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.entities.StudentEntity;
import ma.pfe.mappers.StudentMapper;
import ma.pfe.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("service1")

public class StudentServiceImpl implements StudentService {

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentRepository repository;
    private StudentMapper mapper;

    public StudentServiceImpl(@Qualifier("repo1") StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Long save(StudentDto dto) {
        LOGGER.debug("start methode save in service");
        StudentEntity s_entity = mapper.convertToEntity(dto);
        return repository.save(s_entity);
    }

    @Override
    public Boolean update(StudentDto dto) {
        LOGGER.debug("start methode update in service");

        StudentEntity s_entity = mapper.convertToEntity(dto);
        return repository.update(s_entity);
    }

    @Override
    public Boolean deleteById(Long id) {
        LOGGER.debug("start methode deleteById in service");

        return  repository.deleteById(id);
    }

    @Override
    public List<StudentDto> selectAll() {

        LOGGER.debug("start methode selectAll in service");


        List<StudentEntity> l_entities = repository.selectAll();
        List<StudentDto> l_dtaos = mapper.convertToDtos(l_entities);

        return  l_dtaos;
    }
}
