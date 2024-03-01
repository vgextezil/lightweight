package edu.extezil.spbbase.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Airplane {
    @Id
    private String id;
    private String name;
    private String code;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return Objects.equals(getId(), airplane.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
