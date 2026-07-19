package SecondaryClasses;
import java.io.*;
import java.util.*;
public abstract class ObjectPlus implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Stores extents of all classes.
     */
    private static Map<Class, List> allExtents = new HashMap<>();
    protected ObjectPlus() {
        Class theClass = this.getClass();
        if (!allExtents.containsKey(theClass))
            allExtents.put(theClass, new ArrayList());
        allExtents.get(theClass).add(this);
    }
    /**
     * Returns extent of given class.
     */
    public static <T extends ObjectPlus> List<T> getExtent(Class<T> type) {
        List<ObjectPlus> extent = allExtents.get(type);
        if (extent == null)
            return Collections.emptyList();
        List<T> result = new ArrayList<>();
        for (ObjectPlus object : extent) {
            result.add(type.cast(object));
        }
        return Collections.unmodifiableList(result);
    }
    /**
     * Prints extent.
     */
    public static void showExtent(Class type) {
        System.out.println();
        System.out.println("==============================");
        System.out.println("Extent of " + type.getSimpleName());
        System.out.println("==============================");
        for (Object obj : getExtent(type))
            System.out.println(obj);
    }

    /**
     * Removes object from extent.
     */
    public void removeFromExtent() {
        Class<?> theClass = getClass();
        if (allExtents.containsKey(theClass))
            allExtents.get(theClass).remove(this);
    }
    /**
     * Saves all extents.
     */
    public static void saveExtents(String fileName) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(allExtents);
        out.close();
    }
    /**
     * Loads all extents.
     */
    public static void loadExtents(String fileName) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if (!file.exists())
            return;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        allExtents = (HashMap<Class, List>) in.readObject();
        in.close();
    }
    /**
     * Clears all extents.
     */
    public static void clearExtents() {
        allExtents.clear();
    }
    /**
     * Returns registered classes.
     */
    public static Set<Class> getRegisteredClasses() {
        return allExtents.keySet();
    }
}