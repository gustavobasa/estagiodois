package com.turmab.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.turmab.helpdesk.domain.enums.Prioridade;
import com.turmab.helpdesk.domain.enums.Status;

@Entity
public class Chamado implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String observacoes;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Tecnico tecnico;

    @ManyToOne
    private Cliente cliente;

    // Construtor padrão
    public Chamado() {
        super();
    }

    // (1) Construtor original (sem prioridade/status)
    public Chamado(Integer id, String titulo, String observacoes,
                   Tecnico tecnico, Cliente cliente) {
        this.id = id;
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.tecnico = tecnico;
        this.cliente = cliente;
        this.dataAbertura = LocalDate.now();
    }

    // (2) Construtor com prioridade/status (ordem: titulo/obs depois)
    public Chamado(Integer id, String titulo, String observacoes,
                   Prioridade prioridade, Status status,
                   Tecnico tecnico, Cliente cliente) {
        this.id = id;
        this.titulo = titulo;
        this.observacoes = observacoes;
        this.prioridade = prioridade;
        this.status = status;
        this.tecnico = tecnico;
        this.cliente = cliente;
        this.dataAbertura = LocalDate.now();
    }

    // (3) Construtor com prioridade/status (ordem: prioridade/status antes)
    //    -> cobre chamadas do tipo: new Chamado(null, PRIORIDADE, STATUS, "titulo", "obs", tec, cli)
    public Chamado(Integer id, Prioridade prioridade, Status status,
                   String titulo, String observacoes,
                   Tecnico tecnico, Cliente cliente) {
        this(id, titulo, observacoes, prioridade, status, tecnico, cliente);
    }

    // Getters e setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public LocalDate getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDate dataAbertura) { this.dataAbertura = dataAbertura; }

    public LocalDate getDataFechamento() { return dataFechamento; }
    public void setDataFechamento(LocalDate dataFechamento) { this.dataFechamento = dataFechamento; }

    public Prioridade getPrioridade() { return prioridade; }
    public void setPrioridade(Prioridade prioridade) { this.prioridade = prioridade; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Tecnico getTecnico() { return tecnico; }
    public void setTecnico(Tecnico tecnico) { this.tecnico = tecnico; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}
