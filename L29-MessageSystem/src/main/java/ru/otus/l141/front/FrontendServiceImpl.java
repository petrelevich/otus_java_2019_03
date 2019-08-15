package ru.otus.l141.front;

import ru.otus.l141.app.FrontendService;
import ru.otus.l141.app.MessageSystemContext;
import ru.otus.l141.app.messages.MsgGetUserId;
import ru.otus.l141.messageSystem.Address;
import ru.otus.l141.messageSystem.Message;
import ru.otus.l141.messageSystem.MessageSystem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tully.
 */
public class FrontendServiceImpl implements FrontendService {
    private final Address address;
    private final MessageSystemContext context;

    private final Map<Integer, String> users = new HashMap<>();

    public FrontendServiceImpl(MessageSystemContext context, Address address) {
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

    public void handleRequest(String login) {
        System.out.println("ask if for " + login);
        Message message = new MsgGetUserId(getAddress(), context.getDbAddress(), login);
        context.getMessageSystem().sendMessage(message);
    }

    public void addUser(int id, String name) {
        users.put(id, name);
        System.out.println("User: " + name + " has id: " + id);
    }

    @Override
    public MessageSystem getMS() {
        return context.getMessageSystem();
    }
}
