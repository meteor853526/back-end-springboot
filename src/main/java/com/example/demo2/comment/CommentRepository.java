package com.example.demo2.comment;

import com.example.demo2.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.awt.*;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {

  @Query(value = "select * from comment c where c.商品編號 = ?1", nativeQuery = true )
  List<Comment> findCommentByproductid(int productid);
}
