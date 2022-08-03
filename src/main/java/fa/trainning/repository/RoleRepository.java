package fa.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.trainning.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findOneById(Integer id);
}
