
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneDirectory {

    private final HashMap<String, List<String>> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (directory.containsKey(lastName)) {
            directory.get(lastName).add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            directory.put(lastName, phoneNumbers);
        }
    }

    public List<String> get(String lastName) {
        if (directory.containsKey(lastName)) {
            return directory.get(lastName);
        } else {
            return new ArrayList<>();
        }
    }
}
