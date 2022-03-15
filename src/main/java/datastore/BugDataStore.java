package datastore;

import entity.Bug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BugDataStore {

    private static BugDataStore instance;

    private final HashMap<String, Bug> cache = new HashMap<>();

    private BugDataStore() {
    }

    public static BugDataStore getInstance() {
        if (instance == null) {
            instance = new BugDataStore();
        }
        return instance;
    }

    public Bug getByUuid(String uuid) {
        return cache.get(uuid);
    }

    public void save(Bug bug) {
        cache.put(bug.getUuid().toString(), bug);
    }

    public void delete(Bug bug) {
        cache.remove(bug.getUuid().toString());
    }

    public List<Bug> getAll() {
        List<Bug> bugs = new ArrayList<>();
        cache.forEach((key, value) -> bugs.add(value));
        return bugs;
    }
}
