
package com.example.week7_task.services;

        import com.example.week7_task.dao.PostDAO;
        import com.example.week7_task.dao.UsersDAO;
        import com.example.week7_task.dto.PostDTO;
        import com.example.week7_task.dto.UserDTO;
        import com.example.week7_task.model.Posts;
        import jakarta.servlet.http.HttpSession;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.time.LocalDateTime;
        import java.util.HashMap;
        import java.util.List;

@Service
public class PostServices {
    @Autowired
    private PostDAO postDAO;

    @Autowired
    private UsersDAO usersDAO;

    private List<Posts> posts;

    public boolean save(Posts post, HttpSession session) {
        UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
        if (userDTO != null) {
            LocalDateTime now = LocalDateTime.now();
            post.setDateCreated(String.valueOf(now));
            // Save the post using postDAO
            postDAO.save(post);
            return true; // Indicate that the save operation was successful
        }
        return false; // Indicate that the save operation failed
    }

    public void fetchPost(HttpSession session) {
        // Implement fetching posts logic here
    }
}