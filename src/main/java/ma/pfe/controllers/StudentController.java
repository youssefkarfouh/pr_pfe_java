package ma.pfe.controllers;
import ma.pfe.dtos.StudentDto;
import ma.pfe.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);


    private StudentService studentService;

    public StudentController(StudentService service) {
        this.studentService = service;
    }

    @PostMapping
    public Long save(@RequestBody StudentDto dto) {

        LOGGER.debug("start methode save in controller : {} " , dto);

        return studentService.save(dto);
    }

    @PutMapping
    public Long update(@RequestBody StudentDto dto) {
        LOGGER.debug("start methode update in controller");

        LOGGER.debug("start method update dto : {} ",dto);
        return studentService.update(dto);
    }


    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        LOGGER.debug("start methode delete in controller");

        return studentService.deleteById(id);
    }

    @GetMapping
    public List<StudentDto> selectAll() {

        LOGGER.debug("start methode selectAll in controller");

        return studentService.selectAll();
    }

}
