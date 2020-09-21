package com.example.demo.question;

import com.example.demo.persistence.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")  //Test
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions();

        return new ResponseEntity<List<Question>>(questions, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/questions/{id}")   //test
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") int id)
            throws RecordNotFoundException {
        Question question = questionService.getQuestionById(id);

        return new ResponseEntity<Question>(question, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/questions") //test
    public ResponseEntity<Question> createQuestion(@RequestBody Question question)
            throws RecordNotFoundException {
        Question created = questionService.createQuestion(question);
        return new ResponseEntity<Question>(created, new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping("/questions/{questionId}/reply")
    public ResponseEntity<List<Reply>> getAllReplies(@PathVariable int questionId) throws RecordNotFoundException {
        List<Reply> replies = questionService.getAllReplies(questionId);

        return new ResponseEntity<List<Reply>>(replies, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/questions/{questionId}/reply")  //test
    public ResponseEntity<Reply> createReply(@PathVariable int questionId, @RequestBody Reply reply) throws RecordNotFoundException {

        Reply updateReply = questionService.createReply(questionId, reply);
        return new ResponseEntity<Reply>(updateReply, new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping("/questions/{question_id}/reply/{id}")   //test
    public ResponseEntity<Reply> getReplyById(@PathVariable int question_id, @PathVariable int id)
            throws RecordNotFoundException {
        Reply reply = questionService.getReplyById(question_id, id);

        return new ResponseEntity<Reply>(reply, new HttpHeaders(), HttpStatus.OK);
    }
}
