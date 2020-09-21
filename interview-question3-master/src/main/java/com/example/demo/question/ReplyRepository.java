package com.example.demo.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    public List<Reply> findByQuestionId(int questionId);
}
