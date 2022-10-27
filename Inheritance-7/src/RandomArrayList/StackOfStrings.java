package RandomArrayList;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings(ArrayList<String> data) {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        data.add(item);
    }

    public String pop() {
        String s = data.get(data.size() - 1);
        data.remove(s);
        return s;
    }

    public String peek() {
        String s = data.get(data.size() - 1);
        return s;
    }

    public boolean isEmpty() {
        if (data.size() == 0) {
            return true;
        }
        return false;
    }
}
