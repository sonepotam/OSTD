package ru.pavel2107.ostd.model;

import javax.persistence.*;

/**
 * Created by admin on 21.02.2016.
 */
@Entity
@Table( name = "accounts")
public class Account {



    @Id
    @Column( name = "iban", nullable = false)
    private String iban;

    @Column( name = "bic", nullable = false)
    private String bic;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!iban.equals(account.iban)) return false;
        return bic.equals(account.bic);

    }

    @Override
    public int hashCode() {
        int result = iban.hashCode();
        result = 31 * result + bic.hashCode();
        return result;
    }


    public Account() {
    }

    public Account(String iban, String bic) {

        this.iban = iban;
        this.bic = bic;
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                '}';
    }
}
