//package com.example.exam.repository;
//
//import com.example.exam.model.ShowCinema;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository
//@Transactional
//public interface CinemarRepository extends JpaRepository<ShowCinema, String> {
//    @Query(value= "select * from show_cinema c where c.movie_id = :id" , nativeQuery= true)
//    Page<ShowCinema> findAllCinemaById(@Param("id") int id, Pageable pageable );
//
//    @Query(value= "select * from show_cinema c join movie m \n" +
//            " where (c.movie_id = m.id) and (m.name like concat('%', :name, '%'))" , nativeQuery= true)
//    Page<ShowCinema> findAllCinemaByMovie(@Param("name") String name, Pageable pageable );
//}
