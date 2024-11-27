package br.com.caroline.orcamento.repositories.filter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LancamentoFilter {
    private String datalancamento;
    private String tipolancamento;
    private String valorlancamento;
    private String cliente;

    public String getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(String datalancamento) {
        this.datalancamento = datalancamento;
    }

    public String getTipolancamento() {
        return tipolancamento;
    }

    public void setTipolancamento(String tipolancamento) {
        this.tipolancamento = tipolancamento;
    }

    public String getValorlancamento() {
        return valorlancamento;
    }

    public void setValorlancamento(String valorlancamento) {
        this.valorlancamento = valorlancamento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
