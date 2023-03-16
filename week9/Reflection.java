import java.util.*;
import java.lang.reflect.*;

class A {
    public String f_A;
}

class B extends A {}

interface X {
    void m_X();
}

class C extends B implements X {
    public String f_C;

    public void m_X() {}
}

class Reflection {

    public static void main(String[] args) {
        System.out.println("checkField(C.class, 'f_A'): " + Reflection.checkField(C.class, "f_A"));
        System.out.println("checkMethod(C.class, 'm_X'): " + Reflection.checkMethod(C.class, "m_X"));
        System.out.println("isClass(C.class): " + Reflection.isClass(C.class));
        System.out.println("isClass(X.class): " + Reflection.isClass(X.class));
        System.out.println("isInterface(C.class): " + Reflection.isInterface(C.class));
        System.out.println("isInterface(X.class): " + Reflection.isInterface(X.class));
        System.out.println("hasAncestor(C.class, 'A'): " + Reflection.hasAncestor(C.class, "A"));
        System.out.println("hasAncestor(C.class, 'C'): " + Reflection.hasAncestor(C.class, "C"));
        System.out.println("hasAncestor(C.class, 'X'): " + Reflection.hasAncestor(C.class, "X"));
        System.out.println("hasAncestor(B.class, 'X'): " + Reflection.hasAncestor(B.class, "X"));
        System.out.println("hasAncestor(X.class, 'X'): " + Reflection.hasAncestor(X.class, "X"));
    }

    public static boolean checkField(Class<?> cls, String fieldName) {

        while (cls != null) {
            try {
                cls.getDeclaredField(fieldName);
                return true;
            } catch (NoSuchFieldException ex) {
                cls = cls.getSuperclass();
            }
        }
        return false;
    }

    public static boolean checkMethod(Class<?> cls, String methodName) {
        try {
            cls.getDeclaredMethod(methodName);
            return true;
        } catch (NoSuchMethodException ex) {
            return false;
        }
    }

    public static boolean isClass(Class<?> cls) {
        return !cls.isInterface();
    }

    public static boolean isInterface(Class<?> cls) {
        return cls.isInterface();
    }


    public static boolean hasAncestor(Class<?> cls, String ancestorName) {
        if (cls == null || ancestorName == null || ancestorName.isEmpty()) {
            return false;
        }
        
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> iface : interfaces) {
            if (iface.getName().equals(ancestorName)) {
                return true;
            }
        }
        Class<?> superClass = cls.getSuperclass();
        if (superClass != null && superClass.getName().equals(ancestorName)) {
            return true;
        }
        
        while (superClass != null) {
            interfaces = superClass.getInterfaces();
            for (Class<?> iface : interfaces) {
                if (iface.getName().equals(ancestorName)) {
                    return true;
                }
            }
            superClass = superClass.getSuperclass();
            if (superClass != null && superClass.getName().equals(ancestorName)) {
                return true;
            }
        }
        
        return false;
    }


    public String WishYouA() {
        return "Happy St. Patrick's Day!";
    }

}
