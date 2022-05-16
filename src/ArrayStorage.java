import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int counter = 0;
        while (storage[counter] != null) {
            storage[counter] = null;
            storage[counter] = storage[counter++];
        }
    }

    void save(Resume r) {
        int counter = 0;
        while (storage[counter] != null || Objects.requireNonNull(storage[counter]).uuid.equals(r.uuid)) {
            storage[counter] = storage[counter++];
        }
        storage[counter] = r;
    }

    Resume get(String uuid) {
        return null;
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {
        return 0;
    }
}
