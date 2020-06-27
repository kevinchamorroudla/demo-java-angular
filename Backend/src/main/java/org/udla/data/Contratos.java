package org.udla.data;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Contratos extends PanacheEntity {

    public String descripcion;
    public BigDecimal monto;

    @ManyToOne
    @JsonbTransient
    public Clientes cliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contratos)) {
            return false;
        }

        Contratos other = (Contratos) o;

        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
