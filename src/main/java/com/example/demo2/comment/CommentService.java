package com.example.demo2.comment;

import com.example.demo2.student.Student;
import com.example.demo2.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CommentService {
  private final CommentRepository commentRepository;

  @Autowired
  public CommentService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public List<Comment> getComment(int productid) {
    return commentRepository.findCommentByproductid(productid);
  }

  public void addNewComment(int productid,String buyer,int star,String content,String time) {
    Comment com = new Comment();
    com.setProductid(productid);
    com.setBuyer(buyer);
    com.setStar(star);
    com.setContent(content);
    com.setTime(time);

    commentRepository.save(com);


  }





}
