package ru.otus.proxy;

/**
 * @author sergey
 * created on 16.01.19.
 */
public final class SecurityAccessImpl implements SecurityAccess{
    @Override
    public void access() {
        System.out.println("access to bank account");
    }
}
