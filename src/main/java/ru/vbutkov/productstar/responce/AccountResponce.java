package ru.vbutkov.productstar.responce;

public class AccountResponce {

    private final AccountResult accountResult;

    public AccountResponce(AccountResult accountResult) {
        this.accountResult = accountResult;
    }

    public AccountResult getAccountResult() {
        return accountResult;
    }
}
