package ma.pfe.mappers;

import ma.pfe.dtos.StudentDto;
import ma.pfe.entities.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class StudentMapper {

    public StudentEntity convertToEntity(StudentDto dto){

        StudentEntity s_entity = new StudentEntity();

        s_entity.setName(dto.getName());
        s_entity.setId(dto.getId());

        return s_entity;

    }

    public StudentDto convertToDto(StudentEntity s_entity){

        StudentDto s_dto = new StudentDto();

        s_dto.setName(s_entity.getName());
        s_dto.setId(s_entity.getId());

        return s_dto;
    }

    public List<StudentEntity> convertToEntites(List<StudentDto> l_dto){

       return l_dto.stream().map( s_dto ->  convertToEntity(s_dto)).collect(Collectors.toList());
    }

    public List<StudentDto> convertToDtos(List<StudentEntity> l_entities){
        return l_entities.stream().map( s_entity ->  convertToDto(s_entity)).collect(Collectors.toList());
    }
}
