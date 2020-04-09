package kae.demo.currencytrendsmonitor.server.api.trade;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

/** */
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;

  @Column(nullable = false, unique = true)
  private String systemId;

  UserEntity() {}

  public UserEntity(String systemId) {
    this.systemId = systemId;
  }

  public String getId() {
    return id;
  }

  public String getSystemId() {
    return systemId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserEntity)) {
      return false;
    }
    UserEntity that = (UserEntity) o;
    return systemId.equals(that.systemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(systemId);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", UserEntity.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("systemId='" + systemId + "'")
        .toString();
  }
}
