package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MaterialCurso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    @OneToOne(cascade = CascadeType.ALL)
    private Curso curso;

    public MaterialCurso() {
    }

    public MaterialCurso(String url) {
        this.url = url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MaterialCurso{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
