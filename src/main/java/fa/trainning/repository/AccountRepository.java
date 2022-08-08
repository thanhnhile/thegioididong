package fa.trainning.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.trainning.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	Account findOneById(Integer id);

	Optional<Account> findByUsername(String username);
}
