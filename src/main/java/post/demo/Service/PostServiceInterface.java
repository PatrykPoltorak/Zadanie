package post.demo.Service;

import post.demo.Model.Post;

import java.util.List;

public interface PostServiceInterface {

    public List<Post> getAllPosts();
    public Post getPost(int id);
    public  void savePost(Post post);
    public void deletePost(int id);

}
