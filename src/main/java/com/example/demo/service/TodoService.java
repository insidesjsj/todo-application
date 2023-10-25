package com.example.demo.service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistance.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public String testService() {
        // TodoEntity 생성
        TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
        // TodoEntity 저장
        repository.save(entity);
        // TodoEntity 검색
        TodoEntity saveEntity = repository.findById(entity.getId()).get();

        return saveEntity.getTitle();
    }


    public List<TodoEntity> create(final TodoEntity entity) {
        log.info("서비스 단");
        // Validations
        validate(entity);

        repository.save(entity);

        log.info("Entity Id : {} is saved. ", entity.getId());

        return repository.findByUserId(entity.getUserId());
    }

    // 검증 메소드
    public void validate(final TodoEntity entity) {
        if(entity == null) {
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null");
        }
        if(entity.getUserId() == null) {
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }

    public List<TodoEntity> retrieve(final String userId) {
        log.info("retrieve...");
        return repository.findByUserId(userId);
    }
}
