package org.ies.bank.components.random;

import org.ies.bank.components.AccountReader;
import org.ies.bank.components.CustomerReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Customer;

import java.util.Random;

public class RandomAccountReader implements AccountReader {

    private final Random random;
    private final CustomerReader customerReader;

    public RandomAccountReader(Random random, CustomerReader customerReader) {
        this.random = random;
        this.customerReader = customerReader;
    }

    @Override
    public Account read() {
        String iban = "ES" + random.nextLong(100000000);
        double saldo = random.nextDouble(10000000);
        Customer cliente = customerReader.read();
        return new Account(
                iban,
                saldo,
                cliente
        );
    }
}
