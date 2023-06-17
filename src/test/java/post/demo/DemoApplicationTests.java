package post.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import post.demo.Model.Post;
import post.demo.Repository.PostRepository;
import post.demo.Service.PostService;
import post.demo.Service.PostServiceInterface;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
}
