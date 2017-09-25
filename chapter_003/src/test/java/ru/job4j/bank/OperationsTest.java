package ru.job4j.bank;

import org.junit.Test;
import ru.job4j.part4.SortingCodes;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test.
 *
 * @author Tatyana Belova (mailto:belovatttt@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class OperationsTest {
    /**
     * Test for addUser.
     */
    @Test
    public void addUserTest() {
        Map<User, LinkedList<Account>> customers = new HashMap<User, LinkedList<Account>>();
        User user = new User("Ann", "passport data");
        try {
            new Operations(customers).addUser(user);
        } catch (UserIsAbsentException uiae) {
            System.out.println("This user already exist");
        }
        assertTrue(customers.containsKey(user));
    }
    /**
     * Test for exception of addUser.
     */
    @Test
    public void addUserExceptionTest() {
        Map<User, LinkedList<Account>> customers = new HashMap<User, LinkedList<Account>>();
        String result = "";
        User user = new User("Ann", "passport data");
        try {
            new Operations(customers).addUser(user);
            new Operations(customers).addUser(user);
        } catch (UserIsAbsentException uiae) {
            result = "This user already exist";
        }
        assertThat(result, is("This user already exist"));
    }
    /**
     * Test for deleteUser.
     */
    @Test
    public void deleteUserTest() {
        Map<User, LinkedList<Account>> customers = new HashMap<User, LinkedList<Account>>();
        User user = new User("Ann", "passport data");
        try {
            new Operations(customers).addUser(user);
        } catch (UserIsAbsentException uiae) {
            System.out.println("This user already exist");
        }
        try {
            new Operations(customers).deleteUser(user);
            } catch (UserIsAbsentException uiae) {
            System.out.println("This user is absent");
        }
        assertFalse(customers.containsKey("user"));
    }
    /**
     * Test for exception of deleteUser.
     */
    @Test
    public void deleteUserExceptionTest() {
        Map<User, LinkedList<Account>> customers = new HashMap<User, LinkedList<Account>>();
        String result = "";
        User user = new User("Ann", "passport data");
        try {
            new Operations(customers).addUser(user);
            user = new User("Tom", "passport data");
            new Operations(customers).deleteUser(user);
        } catch (UserIsAbsentException uiae) {
            result = "This user is absent";
        }
        assertThat(result, is("This user is absent"));
    }
    /**
     * Test for addAccountToUser.
     */
    @Test
    public void addAccountToUserTest() {
        Map<User, LinkedList<Account>> customers = new HashMap<User, LinkedList<Account>>();
        User user = new User("Ann", "passport data");
        Account account = new Account("12345", 10.25);
        try {
            new Operations(customers).addUser(user);
            new Operations(customers).addAccountToUser(user, account);
        } catch (UserIsAbsentException uiae) {
            System.out.println("This user is absent");
        }
        assertTrue(customers.get(user).contains(account));
    }
    /**
     * Test for exception of addAccountToUser.
     */
    @Test
    public void addAccountToUserExceptionTest() {
        String result = "";
        Map<User, LinkedList<Account>> customers = new HashMap<User, LinkedList<Account>>();
        User user = new User("Ann", "passport data");
        Account account = new Account("12345", 10.25);
        try {
            new Operations(customers).addUser(user);
            user = new User("Tom", "passport data");
            new Operations(customers).addAccountToUser(user, account);
        } catch (UserIsAbsentException uiae) {
            result = "This user is absent" ;
        }
        assertThat(result, is("This user is absent"));
    }
    /**
     * Test for exception of deleteAccountFromUser.
     */
    @Test
    public void deleteAccountFromUserExceptionTest() {
        String result = "";
        Map<User, LinkedList<Account>> customers = new HashMap<User, LinkedList<Account>>();
        User user = new User("Ann", "passport data");
        Account account = new Account("12345", 10.25);
        try {
            new Operations(customers).addUser(user);
            new Operations(customers).addAccountToUser(user, account);
            new Operations(customers).deleteAccountFromUser(user, new Account("1", 0.01));
        } catch (UserIsAbsentException uiae) {
            System.out.println("This user is absent");
        } catch (AccountIsAbsentException aiae) {
            result = "This account is not exist";
        }
        assertThat(result, is("This account is not exist"));
    }
    /**
     * Test for deleteAccountFromUser.
     */
    @Test
    public void deleteAccountFromUserTest() {
        Map<User, LinkedList<Account>> customers = new HashMap<User, LinkedList<Account>>();
        User user = new User("Ann", "passport data");
        Account account = new Account("12345", 10.25);
        try {
            new Operations(customers).addUser(user);
            new Operations(customers).addAccountToUser(user, account);
            new Operations((customers)).addAccountToUser(user, new Account("123", 100));
            new Operations(customers).deleteAccountFromUser(user, account);
        } catch (UserIsAbsentException uiae) {
            System.out.println("This user is absent");
        } catch (AccountIsAbsentException aiae) {
            System.out.println("This account doesn't exist");
        }
        assertFalse(customers.get(user).contains(account));
    }
    /**
     * Test for deleteAccountFromUser.
     */
    @Test
    public void getUserAccountsTest() {
        Map<User, LinkedList<Account>> customers = new HashMap<User, LinkedList<Account>>();
        User user = new User("Ann", "passport data");
        Account account = new Account("12345", 10.25);
        List<Account> result = null;
        try {
            new Operations(customers).addUser(user);
            new Operations(customers).addAccountToUser(user, account);
            result = new Operations(customers).getUserAccounts(user);
        } catch (UserIsAbsentException uiae) {
            System.out.println("This user is absent");
        }
        StringBuffer s = new StringBuffer();
        for (Account a : result) {
            s.append(a.getRequisites());
            s.append(a.getValue());
        }
        assertThat(s.toString(), is("1234510.25"));
    }
    /**
     * Test for transferMoney for src value.
     */
    @Test
    public void transferMoneyForSrcTest() {
        Map<User, LinkedList<Account>> customers = new HashMap<User, LinkedList<Account>>();
        User user1 = new User("Ann", "passport data");
        Account account1 = new Account("12345", 10.25);
        User user2 = new User("Tom", "passport data");
        Account account2 = new Account("23456", 100.25);
        try {
            new Operations(customers).addUser(user1);
            new Operations(customers).addAccountToUser(user1, account1);
            new Operations(customers).addUser(user2);
            new Operations(customers).addAccountToUser(user2, account2);
            new Operations(customers).transferMoney(user1, account1, user2, account2, 5.05);
        } catch (UserIsAbsentException uiae) {
            System.out.println("This user is absent");
        } catch (AccountIsAbsentException aiae) {
            System.out.println("This account is absent");
        }
        assertThat(customers.get(user1).getFirst().getValue(), is(5.2));
    }
    /**
     * Test for transferMoney for dst value.
     */
    @Test
    public void transferMoneyForDstTest() {
        Map<User, LinkedList<Account>> customers = new HashMap<User, LinkedList<Account>>();
        User user1 = new User("Ann", "passport data");
        Account account1 = new Account("12345", 10.25);
        User user2 = new User("Tom", "passport data");
        Account account2 = new Account("23456", 100.25);
        try {
            new Operations(customers).addUser(user1);
            new Operations(customers).addAccountToUser(user1, account1);
            new Operations(customers).addUser(user2);
            new Operations(customers).addAccountToUser(user2, account2);
            new Operations(customers).transferMoney(user1, account1, user2, account2, 5.05);
        } catch (UserIsAbsentException uiae) {
            System.out.println("This user is absent");
        } catch (AccountIsAbsentException aiae) {
            System.out.println("This account is absent");
        }
        assertThat(customers.get(user2).getFirst().getValue(), is(105.3));
    }
    /**
     * Test for transferMoney for impossible operation.
     */
    @Test
    public void transferMoneyForImpossibleOperationTest() {
        Map<User, LinkedList<Account>> customers = new HashMap<User, LinkedList<Account>>();
        User user1 = new User("Ann", "passport data");
        Account account1 = new Account("12345", 10.25);
        User user2 = new User("Tom", "passport data");
        Account account2 = new Account("23456", 100.25);
        boolean result = true;
        try {
            new Operations(customers).addUser(user1);
            new Operations(customers).addAccountToUser(user1, account1);
            new Operations(customers).addUser(user2);
            new Operations(customers).addAccountToUser(user2, account2);
            result = new Operations(customers).transferMoney(user1, account1, user2, account2, 100);
        } catch (UserIsAbsentException uiae) {
            System.out.println("This user is absent");
        } catch (AccountIsAbsentException aiae) {
            System.out.println("This account is absent");
        }
        assertFalse(result);
    }
}
