package com.example.demo2.order;

import com.example.demo2.shop_car.Shop_Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Order_pdRepository extends JpaRepository<Order_pd,Long> {
  @Query(value = "select * from product p,order_pd o where p.owner = ?1 and o.商品編號 = p.id", nativeQuery = true )
  List<Order_pd> findOrder_pd(String owner);

  @Query(value = "select * from order_pd o where o.購買者 = ?1 and o.訂單狀態 = '已出貨'", nativeQuery = true )
  List<Order_pd> findBuyerOrder_pd(String buyer);

  @Query(value = "select * from order_pd o where o.購買者 = ?1 and (o.訂單狀態 = '買方已收貨' or o.訂單狀態 = '已填寫評論')", nativeQuery = true )
  List<Order_pd> findBuyerhistoryOrder_pd(String buyer);


  @Modifying(clearAutomatically = true)
  @Query(value ="update order_pd o set o.訂單狀態 = '已出貨' where o.訂單編號 = ?1", nativeQuery = true )
  void updateState(int id);

  @Modifying(clearAutomatically = true)
  @Query(value ="update order_pd o set o.訂單狀態 = '買方已收貨' where o.訂單編號 = ?1", nativeQuery = true )
  void updatebuyState(int id);

  @Modifying(clearAutomatically = true)
  @Query(value ="update order_pd o set o.訂單狀態 = '已填寫評論' where o.訂單編號 = ?1", nativeQuery = true )
  void updatebuyCommentState(int id);

}
