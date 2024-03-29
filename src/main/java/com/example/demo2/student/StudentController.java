package com.example.demo2.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
@CrossOrigin("http://localhost:3000/")
public class StudentController {
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getStudent() {
    return studentService.getStudent();
  }

  @PostMapping
  public void registerNewStudent(@RequestBody Student student) {
    studentService.addNewStudent(student);
  }

  @DeleteMapping(path= "{StudentId}")
  public void setStudentService(@PathVariable("StudentId") Long studentId){
    studentService.deleteStudent(studentId);
  }

  @PutMapping(path= "{studentId}")
  public void updateStudent(
    @PathVariable("studentId") Long studentId,
    @RequestParam(required = false) String name,
    @RequestParam(required = false) String email) {

    studentService.updateStudent(studentId,name,email);
  }
}
