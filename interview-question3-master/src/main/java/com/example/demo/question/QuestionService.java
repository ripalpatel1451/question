package com.example.demo.question;

import com.example.demo.persistence.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ReplyRepository replyRepository;

    public List<Question> getAllQuestions()
    {
        List<Question> questions = questionRepository.findAll();

        if(questions.size() > 0) {
            return questions;
        } else {
            return new ArrayList<Question>();
        }
    }

    public Question getQuestionById(int id) throws RecordNotFoundException
    {
        Optional<Question> question = questionRepository.findById(id);

        if(question.isPresent()) {
            return question.get();
        } else {
            throw new RecordNotFoundException("No question exist for given id");
        }
    }

    public Question createQuestion(Question question) throws RecordNotFoundException
    {
        return questionRepository.save(question);
    }

    public List<Reply> getAllReplies(int id) throws RecordNotFoundException
    {
        Optional<Question> questionOptional = questionRepository.findById(id);

        if(!questionOptional.isPresent()){
            throw new RecordNotFoundException("id -" +id);
        }

        Question question = questionOptional.get();

        List<Reply> replies = replyRepository.findByQuestionId(id);

        if(replies.size() > 0) {
            return replies;
        } else {
            return new ArrayList<Reply>();
        }
    }

    public Reply createReply(int id, Reply reply) throws RecordNotFoundException
    {
        Optional<Question> questionOptional = questionRepository.findById(id);

        if(!questionOptional.isPresent()){
            throw new RecordNotFoundException("id -" +id);
        }

        Question question = questionOptional.get();
        reply.setQuestion(question);

        return replyRepository.save(reply);

//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(reply.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).build();
    }

    public Reply getReplyById(int question_id, int id) throws RecordNotFoundException
    {
        Optional<Question> question = questionRepository.findById(question_id);

        if(!question.isPresent()) {
            throw new RecordNotFoundException("No question exist for given id");
        }

        Optional<Reply> reply = replyRepository.findById(id);
        if(!reply.isPresent()){
            throw new RecordNotFoundException("id - " + id);
        }
        return reply.get();
    }


}
