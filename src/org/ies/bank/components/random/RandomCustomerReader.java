package org.ies.bank.components.random;

import org.ies.bank.components.CustomerReader;
import org.ies.bank.model.Customer;

import java.util.Random;

public class RandomCustomerReader implements CustomerReader {
    private final static String[] NAMES = {
            "Peppa", "George", "Bob", "Pocoyo", "Calamardo", "Elly"
    };

    private final static String[] SURNAMES = {
            "Pig", "Esponja", "López", "Pérez", "Sánchez", "Álvarez"
    };
    private final Random random;

    public RandomCustomerReader(Random random) {
        this.random = random;
    }

    @Override
    public Customer read() {
        return new Customer(
                random.nextLong(1000000) + "X",
                NAMES[random.nextInt(NAMES.length)],
                SURNAMES[random.nextInt(SURNAMES.length)]
        );
    }

}
