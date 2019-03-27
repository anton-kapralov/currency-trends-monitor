package kae.demo.currencytrendsmonitor.server.api.trade;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/** */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIT {

  @Autowired private TestEntityManager em;

  @Autowired private UserRepository repository;

  @After
  public void tearDown() {
    repository.deleteAll();
  }

  @Test
  public void findBySystemId_returnsPersistedUser_whenKnownSystemId() {
    String systemId = "known-system-id-1";
    em.persist(new UserEntity(systemId));

    Optional<UserEntity> optionalUser = repository.findBySystemId(systemId);

    assertThat(optionalUser).isPresent();
    assertThat(optionalUser.get().getSystemId()).isEqualTo(systemId);
  }

  @Test
  public void findBySystemId_returnsEmptyOptional_whenUnknownSystemId() {
    Optional<UserEntity> optionalUser = repository.findBySystemId("unknown-system-id-1");

    assertThat(optionalUser).isEmpty();
  }
}
