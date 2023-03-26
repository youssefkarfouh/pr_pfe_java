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

    @PostMapping("/add")
    public StudentDto save(@RequestBody StudentDto dto) {

        LOGGER.debug("start methode save in controller");

        return studentService.save(dto);
    }

    @PutMapping("/update")
    public Boolean update(@RequestBody StudentDto dto) {
        LOGGER.debug("start methode update in controller");

        return true;
    }


    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") long id) {
        LOGGER.debug("start methode delete in controller");

        return studentService.deleteById(id);
    }

    @GetMapping("/all")
    public List<StudentDto> selectAll() {

        LOGGER.debug("start methode selectAll in controller");

        return studentService.selectAll();
    }

}
