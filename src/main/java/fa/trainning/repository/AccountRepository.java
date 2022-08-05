package fa.trainning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.trainning.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	Account findOneByUserName(String userName);
}
