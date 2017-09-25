package ru.job4j.bank;

import java.util.*;

public class Operations {
    private Map<User, LinkedList<Account>> customers;

    public Operations() {
        this.customers = new HashMap<User, LinkedList<Account>>();
    }
    public Operations(Map<User, LinkedList<Account>> customers) {
        this.customers = customers;
    }

    public void addUser(User user) throws UserIsAbsentException {
        if (!this.customers.containsKey(user)) {
            this.customers.put(user, new LinkedList<Account>());
        } else {
            throw new UserIsAbsentException("User is not exist") ;
        }

    }
    public void deleteUser(User user) throws UserIsAbsentException{
        if (!this.customers.containsKey(user)) {
            throw new UserIsAbsentException("User is not exist") ;
        } else {
            this.customers.remove(user);
        }
    }
    public void addAccountToUser(User user, Account account) throws UserIsAbsentException {
        if (this.customers.containsKey(user)) {
            LinkedList<Account> customerAccounts = this.customers.get(user);
            customerAccounts.add(account);
            this.customers.put(user, customerAccounts);
        } else {
            throw new UserIsAbsentException("User is not exist");
        }
    }
    public void deleteAccountFromUser(User user, Account account) throws UserIsAbsentException, AccountIsAbsentException {
        if (this.customers.containsKey(user)) {
            LinkedList<Account> customerAccounts = this.customers.get(user);
            if (customerAccounts.contains(account)) {
                customerAccounts.remove(account);
            } else {
                throw new AccountIsAbsentException("Account is not exist");
            }
            this.customers.put(user, customerAccounts);
        } else {
            throw new UserIsAbsentException("User is not exist");
        }
    }
    public List<Account> getUserAccounts (User user) throws UserIsAbsentException {
        if (!this.customers.containsKey(user)) {
            throw new UserIsAbsentException("User is not exist");
        }
        return this.customers.get(user);
    }
    public boolean transferMoney (User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) throws UserIsAbsentException {
        boolean srcResult = false;
        boolean dstResult = false;
        if (! this.customers.containsKey(srcUser) || ! this.customers.containsKey(dstUser) ) {
            throw new UserIsAbsentException("User is not exist");
        }
        LinkedList<Account> srcList = this.customers.get(srcUser);
        LinkedList<Account> dstList = this.customers.get(dstUser);
        Account accountSrc = null;
        Account accountDst = null;
        for (Account src: srcList) {
           if (src.equals(srcAccount)) {
               if (src.getValue() >= amount) {
                   srcResult = true;
                   accountSrc = src;
               }
               break;
           }
        }
        for (Account dst: dstList) {
            if (dst.equals(dstAccount)) {
                dstResult = true;
                accountDst = dst;
                break;
            }
        }
        if (srcResult && dstResult) {
            accountSrc.setValue(accountSrc.getValue() - amount);
            accountDst.setValue(accountDst.getValue() + amount);
        }
        return srcResult && dstResult;

    }

}
