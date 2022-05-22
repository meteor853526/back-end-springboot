package com.example.demo2.shop_car;

import com.example.demo2.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.List;
import java.util.Optional;

@Repository
public interface Shop_CarRepository extends JpaRepository<Shop_Car,Long> {
//  @Query("SELECT s FROM Student s WHERE s.email = ?1")
//  Optional<Shop_Car> findShop_CarByEmail(String email);

  @Query("SELECT s FROM Shop_Car s WHERE s.email = ?1 ")
  List<Shop_Car> findShop_CarByEmail(String email);


  @Transactional
  @Modifying
  @Query("delete from Shop_Car s where s.id = ?1")
  void deleteCar(int id);

  @Transactional
  @Modifying
  @Query("delete from Shop_Car s where s.id = ?1")
  void deletenumCar(int id);

  @Modifying(clearAutomatically = true)
  @Query(value ="update shop_car s set s.number = s.number + 1 where s.id = ?1", nativeQuery = true )
  void addnumCar(int id);

  @Modifying(clearAutomatically = true)
  @Query(value ="update shop_car s set s.number = s.number - 1 where s.id = ?1 and s.number > 1", nativeQuery = true )
  void cutnumCar(int id);

}
