package ru.otus.l141.db;

import ru.otus.l141.app.DBService;
import ru.otus.l141.app.MessageSystemContext;
import ru.otus.l141.messageSystem.Address;
import ru.otus.l141.messageSystem.MessageSystem;

/**
 * Created by tully.
 */
public class DBServiceImpl implements DBService {
    private final Address address;
    private final MessageSystemContext context;

    public DBServiceImpl(MessageSystemContext context, Address address) {
        this.context = context;
        this.address = address;
    }

    public void init() {
        context.getMessageSystem().addAddressee(this);
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public MessageSystem getMS() {
        return context.getMessageSystem();
    }

    public int getUserId(String name) {
        //todo: load id from db
        System.out.println("load id for " + name);
        return name.hashCode();
    }
}
