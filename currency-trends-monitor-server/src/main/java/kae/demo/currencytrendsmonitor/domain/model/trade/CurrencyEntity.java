package kae.demo.currencytrendsmonitor.domain.model.trade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/** */
@Entity
@Table(name = "currency")
public class CurrencyEntity implements Serializable {

  @Id private Integer id;

  @Column(nullable = false, unique = true)
  private String isoCode;

  @Column(nullable = false)
  private String name;

  CurrencyEntity() {}

  /** @deprecated For tests only. */
  @Deprecated
  CurrencyEntity(Integer id, String isoCode, String name) {
    this.id = id;
    this.isoCode = isoCode;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public String getIsoCode() {
    return isoCode;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CurrencyEntity)) {
      return false;
    }
    CurrencyEntity that = (CurrencyEntity) o;
    return isoCode.equals(that.isoCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isoCode);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", CurrencyEntity.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("isoCode='" + isoCode + "'")
        .add("name='" + name + "'")
        .toString();
  }
}
