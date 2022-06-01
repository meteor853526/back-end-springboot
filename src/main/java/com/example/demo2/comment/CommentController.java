package com.example.demo2.comment;

import com.example.demo2.order.Order_pdService;
import com.example.demo2.student.Student;
import com.example.demo2.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Comment")
@CrossOrigin("http://localhost:3000/")
public class CommentController {

  private final CommentService commentService;
  private final Order_pdService order_pdService;

  @Autowired
  public CommentController(CommentService commentService,Order_pdService order_pdService) {
    this.commentService = commentService;
    this.order_pdService = order_pdService;
  }

  @GetMapping
  public List<Comment> getComment(@RequestParam("productid") int productid) {
    return commentService.getComment(productid);
  }



  @PostMapping
  public void addNewComment(@RequestParam("id") int id,
                            @RequestParam("productid") int productid,
                            @RequestParam("buyer") String buyer,
                            @RequestParam("star") int star,
                            @RequestParam("content") String content,
                            @RequestParam("time") String time) {
    commentService.addNewComment(productid,buyer,star,content,time);
    order_pdService.updateCommentOrder(id);

  }



}
