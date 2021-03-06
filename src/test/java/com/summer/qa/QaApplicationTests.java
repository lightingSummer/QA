package com.summer.qa;

import com.summer.qa.dao.MessageMapper;
import com.summer.qa.dao.QuestionMapper;
import com.summer.qa.dao.UserMapper;
import com.summer.qa.model.Message;
import com.summer.qa.model.Question;
import com.summer.qa.model.User;
import com.summer.qa.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QaApplicationTests {

  @Autowired private UserMapper userMapper;

  @Autowired private QuestionMapper questionMapper;

  @Autowired private QuestionService questionService;

  @Autowired private MessageMapper messageMapper;

  @Test
  public void contextLoads() {}

  @Test
  public void userUpdate() {
    for (int i = 96; i <= 207; i++) {
      User user = new User();
      user.setId(i);
      user.setHeadUrl(
          String.format("http://images.nowcoder.com/head/%dt.png", new Random().nextInt(1000)));
      user.setName("User" + i);
      userMapper.updateByPrimaryKeySelective(user);
    }
  }

  @Test
  public void userTest1() {
    User user = new User();
    user.setName("鹧鸪天");
    user.setSalt("123");
    user.setPassword("123");
    user.setHeadUrl("http://ps2a1gxx1.bkt.clouddn.com/44188a19512f4bd6b022886877901705.jpg");
    userMapper.insertSelective(user);
  }

  @Test
  public void userTest2() {
    System.out.println(userMapper.selectByName("青杏儿"));
  }

  @Test
  public void questionTest1() {
    for (int i = 0; i < 10; i++) {
      Question question = new Question();
      question.setTitle("Question" + i);
      question.setUserId(1);
      question.setCreatedDate(new Date());
      question.setContent("content");
      questionMapper.insertSelective(question);
    }
    System.out.println(questionService.getLatestQuestions(1, 1, 5));
  }

  @Test
  public void questionTest2() {

    Question question = new Question();
    question.setTitle("QuestionTemp");
    question.setUserId(1);
    question.setCreatedDate(new Date());
    question.setContent("content");

    System.out.println(questionService.addQuestion(question));
  }

  @Test
  public void messageTest1() {
    Message message = new Message();
    message.setFromId(1);
    message.setToId(7);
    System.out.println(message.getConversationId());
  }

  @Test
  public void messageTest2() {
    System.out.println(messageMapper.selectConversationListByUserId(22));
  }
}
