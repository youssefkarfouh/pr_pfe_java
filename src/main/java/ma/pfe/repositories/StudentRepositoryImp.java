package ma.pfe.repositories;

import ma.pfe.entities.StudentEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository("repo1")
public class StudentRepositoryImp implements StudentRepository{

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentRepositoryImp.class);

    @Override
    public Long save(StudentEntity e) {
      LOGGER.debug("start methode save in repo");
        return null;
    }

    @Override
    public Boolean update(StudentEntity e) {
        LOGGER.debug("start methode update in repo");
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        LOGGER.debug("start methode deleteById in repo");
        return null;
    }

    @Override
    public List<StudentEntity> selectAll() {
        LOGGER.debug("start methode selectAll in repo");
        return new ArrayList<>();
    }
}
