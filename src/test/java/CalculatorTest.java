import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest
{
    //Instance de notre objet "calculator"
    private Calculator calculator;
    //Instance de l'objet "Instant", pour le temps d'exécution
    private static Instant startTime;

    //Méthode de départ du timer, qui s'exécute en premier avant tous les tests
    @BeforeAll
    static public void startTimer(){
        startTime = Instant.now(); //Récupération du temps actuel
    }

    //Méthode de fin du timer avec affichage console
    @AfterAll
    static public void displayTimer(){
        Instant stopTime = Instant.now();
        long totalTime = Duration.between(startTime,stopTime).toMillis();
        System.out.println(GetCoolors.RED+"Le temps total de test: " + totalTime + " ms"+GetCoolors.RESET);
    }

    //Méthode pour instancier Calculator, pour chaque test
    @BeforeEach
    public void initCalculator(){
        System.out.println(GetCoolors.BLUE+"Methode appelee avant chaque test"+GetCoolors.RESET);
        calculator = new Calculator();
    }

    //Test d'une addition de 2 nombres
    @Test
    void testAddition2Nombres(){
        //Arrange
        int a = 7;
        int b = 3;

        //Act
        int somme = calculator.add(a,b);
        //Assert
        assertEquals(10, somme);
    }

    //Test d'une division de 2 nombres
    @Test
    void testDiviser2Nombres(){
        //Arrange
        int a = 10;
        int b = 5;

        //Act
        int divise = calculator.divide(a,b);

        //Assert
        assertEquals(2, divise);
    }
}
