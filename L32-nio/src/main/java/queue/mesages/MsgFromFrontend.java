package queue.mesages;

public class MsgFromFrontend extends Message {

    private final String data;

    public MsgFromFrontend(String data) {
        this.data = data;
    }

    @Override
    public String process() {
        return data;
    }

    @Override
    public String toString() {
        return "MsgFromFrontend{" +
                "data='" + data + '\'' +
                '}';
    }
}
