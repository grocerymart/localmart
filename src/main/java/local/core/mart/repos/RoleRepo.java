package local.core.mart.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import local.core.mart.entities.Role;

public interface RoleRepo extends CrudRepository<Role, Integer>{
	
	@Query("SELECT r FROM roles r WHERE r.name = :rolename")
	public Role getRoleByRolename(@Param("rolename") String rolename);


}
