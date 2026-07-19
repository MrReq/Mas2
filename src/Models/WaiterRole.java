package Models;
import SecondaryClasses.ObjectPlus;
import SecondaryClasses.ObjectPlusPlus;

import java.util.List;

public class WaiterRole extends ObjectPlusPlus {
    private static final long serialVersionUID = 1L;
    public static List<WaiterRole> getWaiterRoleExtent() {
        return ObjectPlus.getExtent(WaiterRole.class);
    }
    public void serveTable() {System.out.println("Serving table...");}
    @Override
    public String toString() {
        return "WaiterRole";
    }
}
