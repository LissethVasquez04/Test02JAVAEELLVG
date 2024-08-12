package org.esfe.Test02JAVAEELLVG.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "ProductoLLVG")
public class ProductoLLVG {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    private String nombreLLVG;

    @OneToMany(mappedBy = "productoLLVG", cascade = CascadeType.ALL)
    private List<DetalleOrdenLLVG> detallesOrdenLLVG;

    
    public Long getId() {
        return id;
    }

    public String getNombreLLVG() {
        return nombreLLVG;
    }

    public List<DetalleOrdenLLVG> getDetallesOrdenLLVG() {
        return detallesOrdenLLVG;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreLLVG(String nombreLLVG) {
        this.nombreLLVG = nombreLLVG;
    }

    public void setDetallesOrdenLLVG(List<DetalleOrdenLLVG> detallesOrdenLLVG) {
        this.detallesOrdenLLVG = detallesOrdenLLVG;
    }
}
