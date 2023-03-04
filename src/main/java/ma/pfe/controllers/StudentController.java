package ma.pfe.controllers;

import ma.pfe.dtos.StudentDto;
import ma.pfe.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {

    String test;
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private StudentService service;
    public StudentController(@Qualifier("service1") StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Long save(StudentDto dto){

        LOGGER.debug("start methode save in controller");

        return  service.save(dto);
    }
    @PutMapping
    public Boolean update(StudentDto dto){
        LOGGER.debug("start methode update in controller");

        return  service.update(dto);
    }

    @DeleteMapping
    public Boolean delete(long id){
        LOGGER.debug("start methode delete in controller");

        return service.deleteById(id);
    }

    @GetMapping
    public List<StudentDto> selectAll(){

        LOGGER.debug("start methode selectAll in controller");

        return service.selectAll();
    }

}
