package com.example.demo.persistance;

import com.example.demo.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    // 스프링 데이터 JPA가 메서드 이름을 파싱해서
    // SELECT * FROM TodoRepository WHERE userId = '{userId}'와 같은 쿼리를 작성해 실행
    // 메서드 이름은 쿼리, 매개변수는 쿼리의 where 문에 들어갈 값을 의미
    List<TodoEntity> findByUserId(String userId);

/*    @Query("select * from Todo t where t.userId = ?1")
    List<TodoEntity> findByuserId(String userId);*/
}
