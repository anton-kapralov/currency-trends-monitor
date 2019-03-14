package kae.demo.currencytrendsmonitor.server.api.trade;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** */
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

  @Id @GeneratedValue private UUID id;

  @Column(nullable = false, unique = true)
  private String systemId;

  UserEntity() {}

  public UserEntity(String systemId) {
    this.systemId = systemId;
  }

  public UUID getId() {
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
