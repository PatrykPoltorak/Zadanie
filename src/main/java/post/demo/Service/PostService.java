package post.demo.Service;

import org.springframework.stereotype.Service;
import post.demo.Model.Post;
import post.demo.Repository.PostRepository;

import java.util.Date;
import java.util.List;

@Service
public class PostService implements PostServiceInterface{
    private PostRepository postRepository;

    PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPost(int id) {
        Post post = postRepository.findById(id);
        return post;
    }

    public List<Post> getAllPostsByDate() {
        return postRepository.findAllByDate();
    }
    public List<Post> getAllPostsByTitle() {
        return postRepository.findAllByTitle();
    }

    @Override
    public void savePost(Post post) {
        post.setDate(new Date());
        postRepository.save(post);
    }

    @Override
    public void deletePost(int id) {
        postRepository.delete(postRepository.findById(id));
    }
}
