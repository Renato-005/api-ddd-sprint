package br.fiap.entities;

import java.util.Objects;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class _BaseEntity {

    private int id;
    private boolean deleted;
//    // Validação para ID
//    public void setId(int id) {
//        if (id < 0) {
//            throw new IllegalArgumentException("ID não pode ser negativo.");
//        }
//        this.id = id;
//    }


    public _BaseEntity() {
    }

    public _BaseEntity(int id, boolean deleted) {
        this.id = id;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        _BaseEntity that = (_BaseEntity) o;
        return id == that.id && deleted == that.deleted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deleted);
    }

    @Override
    public String toString() {
        return "_BaseEntity{" +
                "id=" + id +
                ", deleted=" + deleted +
                '}';
    }
}


