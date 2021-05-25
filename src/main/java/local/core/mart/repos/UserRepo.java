package local.core.mart.repos;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import local.core.mart.entities.User;
 
public interface UserRepo extends CrudRepository<User, Long> {
 
@Query("SELECT u FROM users u WHERE u.username = :username")
public User getUserByUsername(@Param("username") String username);

@Modifying
@Query(value = "insert into users_roles (user_id,role_id) VALUES (:user_id,:role_id)", nativeQuery = true)
@Transactional
void addRole(@Param("user_id") Long user_id, @Param("role_id") Integer role_id);


}