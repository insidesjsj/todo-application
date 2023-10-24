package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity // 자바 클래스를 엔티티로 지정하려면 이 어노테이션 필요. 이름도 부여할 수 있다. ex) @Entity("TodoEntity")
@Table(name = "Todo")   // 테이블 이름 지정. 데이터베이스의 Todo테이블에 매핑된다는 뜻. 지정을 하지 않는 경우 클래스의 이름을 테이블 이름으로 간주.
public class TodoEntity {
    @Id // 기본키가 될 필드에 지정
    @GeneratedValue(generator = "system-uuid")  // ID 자동 생성
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;      // 이 오브젝트의 아이디
    private String userId;  // 이 오브젝트를 생성한 사용자의 아이디
    private String title;   // Todo 타이틀(예: 운동하기)
    private boolean done;   // Todo를 완료한 경우 true
}
