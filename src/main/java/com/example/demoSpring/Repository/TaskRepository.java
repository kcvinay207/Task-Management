package com.example.demoSpring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demoSpring.DTO.Task;


public interface TaskRepository extends JpaRepository<Task, Integer>

{
                 @Query("select t.tittle from Task t where t.target_date=?1")
                 public List<Object> taskList(String target);
}
