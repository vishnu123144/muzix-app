package com.stackroute.userservice.repo;
import com.stackroute.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,String> {
    //  User getByUsernameAndPassword(String username, String password);
    //Login
    Optional<User> findByEmailAndPassword(String email, String password);
}
//package com.stackroute.userservice.repo;
//
//import com.stackroute.userservice.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//
//public interface UserRepository extends JpaRepository<User, String> {
//
//   // @Query("from User where user_email=?1")
//    //public List<User> findByEMAILID(String email);
//
//    //@Query("from User where user_email=?1 and user_password=?2")
//    //login
//    User findByEmailAndPassword(String emailId, String password);
//}
