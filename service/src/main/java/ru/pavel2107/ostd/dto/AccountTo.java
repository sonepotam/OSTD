package ru.pavel2107.ostd.dto;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by admin on 22.02.2016.
 */
public class AccountTo implements Serializable {

    static final long serialVersionUID = 1L;

    protected String iban;

    protected String bic;


    public AccountTo(String iban, String bic) {
        this.iban = iban;
        this.bic = bic;
    }

    public AccountTo() { }

       public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    @Override
    public String toString() {
        return "AccountTo{" +
                " iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                '}';
    }



}
