
package ProyectoNegocio.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;




    @Data
    @Entity
    @Table(name = "inventario")
    public class Inventario {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idInventario;
        private String nombre;
        private String descripcion;
        private double precio;
        private boolean activo;

        public Inventario() {
        }

        
        public Inventario(String descripcion, double precio, boolean activo) {
            this.descripcion = descripcion;
            this.precio = precio;
            this.activo = activo;
        }

    

    }
