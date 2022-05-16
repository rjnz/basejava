import java.util.Arrays;

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
        while (storage[counter] != null) {
            if (storage[counter].uuid.equals(r.uuid)) {
                storage[counter] = r;
                return;
            }
            storage[counter] = storage[counter++];
        }
        storage[counter] = r;
    }

    Resume get(String uuid) {
        int counter = 0;
        while (storage[counter] != null && !storage[counter].uuid.equals(uuid)) {
            counter++;
        }
        return storage[counter];
    }

    void delete(String uuid) {
        int counter = 0;
        while (storage[counter] != null && !storage[counter].uuid.equals(uuid)) {
            counter++;
        }
        do {
            storage[counter] = storage[++counter];
        } while (storage[counter] != null);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(this.storage, this.size());
    }

    int size() {
        int counter = 0;
        while (storage[counter] != null) {
            counter++;
        }
        return counter;
    }
}
