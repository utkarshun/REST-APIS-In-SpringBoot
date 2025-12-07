package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student=new Student(1,"Utkarsh","Kher");
        return student;
    }

    //http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"Utkarsh","kher"));
        students.add(new Student(2,"Rahul","Narayan"));
        students.add(new Student(3,"Shifa","Maqsood"));
        students.add(new Student(5,"Priyanshu","Singh"));
        students.add(new Student(6,"Prabhat","Sharma"));
        return students;
    }
    //Creating Spring Boot Rest API with Path Variable(@Path variable)
    //{id} - URI template variable
    //http://localhost:8080/students/1
    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId){
        return new Student(studentId,"Utkarsh","Kher");
    }
//    http://localhost:8080/students/1/utkkarsh/kher
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,@PathVariable("first-name") String firstName,@PathVariable("last-name") String lastName){
        return new Student(studentId,firstName,lastName);
    }
    //Spring boot REST API with REQUEST PARAM
//     http://localhost:8080/students/query/?id=1
//    @GetMapping("/students/query")
//    public Student studentRequestVariable(@RequestParam int id){
//        return new Student(id,"Utkarsh","Kher");
//    }
//    http://localhost:8080/students/query/?id=1&firstName=Ramesh&lastName=Fadatare
    @GetMapping("/students/query")
    public Student studentRequestVariable(@RequestParam int id,@RequestParam String firstName,@RequestParam String lastName){
        return new Student(id,firstName,lastName);
}
}
