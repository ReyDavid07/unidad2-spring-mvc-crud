package com.udec.unidad2mvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El número de pedido es obligatorio")
    @Column(name = "numero_pedido", unique = true, nullable = false)
    private String numeroPedido;

    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String cliente;

    @NotBlank(message = "El producto o plato solicitado es obligatorio")
    private String producto;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad mínima es 1")
    private Integer cantidad;

    @NotNull(message = "El valor unitario es obligatorio")
    @Positive(message = "El valor unitario debe ser mayor que cero")
    private BigDecimal valorUnitario;

    @NotBlank(message = "El estado es obligatorio")
    private String estado = "PENDIENTE";

    private LocalDate fecha = LocalDate.now();

    public Pedido() {
    }

    public Pedido(Long id, String numeroPedido, String cliente, String producto, Integer cantidad, BigDecimal valorUnitario, String estado, LocalDate fecha) {
        this.id = id;
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.estado = estado;
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        if (valorUnitario == null || cantidad == null) {
            return BigDecimal.ZERO;
        }
        return valorUnitario.multiply(BigDecimal.valueOf(cantidad));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroPedido() { return numeroPedido; }
    public void setNumeroPedido(String numeroPedido) { this.numeroPedido = numeroPedido; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public BigDecimal getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(BigDecimal valorUnitario) { this.valorUnitario = valorUnitario; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
