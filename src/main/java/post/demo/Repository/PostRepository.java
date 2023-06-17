package post.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import post.demo.Model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("Select p from Post p where p.id = ?1")
    Post findById(int id);
    @Query("Select p from Post p order by id")
    List<Post> findAll();
    @Query("Select p from Post p order by date")
    List<Post> findAllByDate();
    @Query("Select p from Post p order by title")
    List<Post> findAllByTitle();
}
