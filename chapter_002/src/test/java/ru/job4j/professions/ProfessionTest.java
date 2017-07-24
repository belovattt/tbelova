package ru.job4j.professions;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Tatyana Belova (mailto:belovatttt@gmail.com)
* @version $Id$
* @since 0.1
*/

public class ProfessionTest {
	/**
	* Test for class Teacher.
	*/
    @Test
    public void teacherTest() {
        Teacher marivanna = new Teacher("Мариванна", 5, 1, "физра");
		Pupil vasya = new Pupil("Вася");
		String result = marivanna.teach(vasya);
        String expected = "Учитель Мариванна учит Вася";
        assertThat(result, is(expected));
    }
	/**
	* Test for class Doctor.
	*/
    @Test
    public void doctorTest() {
        Doctor aybolit = new Doctor("Айболит", 50, "ветеринар");
		Person zaychik = new Person("Зайчик");
		aybolit.diagnose(zaychik, "отсутствие ножек");
		String result = aybolit.heal(zaychik);
        String expected = "Доктор Айболит лечит Зайчик от отсутствие ножек";
        assertThat(result, is(expected));
    }
	/**
	* Test for class Engineer.
	*/
    @Test
    public void engineerTest() {
        Engineer shpuntik = new Engineer("Шпунтик", 1, "конструктор");
		Plan hoover = new Plan("пылесос");
		String result = shpuntik.design(hoover);
        String expected = "Инженер-конструктор Шпунтик разрабатывает пылесос";
        assertThat(result, is(expected));
    }
}