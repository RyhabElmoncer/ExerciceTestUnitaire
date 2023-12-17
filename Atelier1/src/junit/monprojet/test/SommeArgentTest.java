package junit.monprojet.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.monprojet.SommeArgent;
import junit.monprojet.UniteDistincteException;

class SommeArgentTest {

    private SommeArgent m12CHF;
    private SommeArgent m14USD;

    @BeforeEach
    void setUp() {
        m12CHF = new SommeArgent(12, "CHF");
        m14USD = new SommeArgent(14, "USD");
    }
    @Test
    void testAddWithDistinctUnits() {
        SommeArgent m12CHF = new SommeArgent(12, "CHF");
        SommeArgent m14USD = new SommeArgent(14, "USD");

        // Utilisation de assertThrows pour vérifier que l'exception est levée
        UniteDistincteException thrown = assertThrows(UniteDistincteException.class, () -> {
            m12CHF.add(m14USD); // Code sous test
        });

        // Vérification du message d'erreur
        assertEquals("unité distincte : CHF != USD", thrown.toString());
    }

    // D'autres méthodes de test peuvent être ajoutées ici
}
