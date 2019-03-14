package kae.demo.currencytrendsmonitor.server.api.trade;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** */
@Entity
@Table(name = "country")
public class CountryEntity implements Serializable {

  @Id private Integer id;

  @Column(nullable = false, unique = true)
  private String code;

  @Column(nullable = false)
  private String name;

  CountryEntity() {}

  public Integer getId() {
    return id;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CountryEntity)) {
      return false;
    }
    CountryEntity that = (CountryEntity) o;
    return code.equals(that.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", CountryEntity.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("code='" + code + "'")
        .add("name='" + name + "'")
        .toString();
  }
}
