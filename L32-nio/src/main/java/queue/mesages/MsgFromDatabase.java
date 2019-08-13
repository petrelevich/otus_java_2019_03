package queue.mesages;

public class MsgFromDatabase extends Message {

    private final String data;

    public MsgFromDatabase(String data) {
        this.data = data;
    }

    @Override
    public String process() {
        return data;
    }

    @Override
    public String toString() {
        return "MsgFromDatabase{" +
                "data='" + data + '\'' +
                '}';
    }
}
