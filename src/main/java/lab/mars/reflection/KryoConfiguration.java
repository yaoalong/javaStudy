//package lab.mars.reflection;
//
//import com.esotericsoftware.kryo.Kryo;
//import com.esotericsoftware.reflectasm.ConstructorAccess;
//import com.esotericsoftware.reflectasm.FieldAccess;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Modifier;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.*;
//
///**
// * Created by haixiao on 2015/6/4. Email: wumo@outlook.com
// */
//public class KryoConfiguration {
//    /**
//     * used to pre-register all the needed classes in kryo
//     */
//    private static Set<Class> resolvedClz;
//    /**
//     * used to deserialize the resource from Map&lt;String,Object&gt;
//     */
//    private static Map<Class, ClassAccess> fieldAccessMap;
//
//    static {
//        resolvedClz = new TreeSet<>((o1, o2) -> o1.getName().compareTo(
//                o2.getName()));
//        fieldAccessMap = new HashMap<>();
//        Set<Class> seedClz = new HashSet<>();
//        // main resource element in data base
//
//        for (Class clz : seedClz) {
//            fieldAccessMap.put(clz, new ClassAccess(clz));
//        }
//
//        // other data type, no need to analyse them in fieldAccessMap
//        seedClz.add(ArrayList.class);
//        seedClz.add(LinkedList.class);
//
//        for (Class seedCls : seedClz)
//            resolveClass(seedCls);
//    }
//
//    private static void resolveClass(Class seedCls) {
//        Field[] fields = seedCls.getFields();
//        for (Field field : fields) {
//            int modifiers = field.getModifiers();
//            if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers))// omit
//                // static
//                // and
//                // final
//                // field
//                continue;
//            Class fieldCls = field.getType();
//            if (!resolvedClz.contains(fieldCls))
//                resolveClass(fieldCls);
//            // analyse generics
//            Type type = field.getGenericType();
//            if (type instanceof ParameterizedType) {
//                ParameterizedType pType = (ParameterizedType) type;
//                Type[] arr = pType.getActualTypeArguments();
//                for (Type tp : arr) {
//                    Class<?> clzz = (Class<?>) tp;
//                    if (!resolvedClz.contains(clzz))
//                        resolveClass(clzz);
//                }
//            }
//        }
//        // finish resolving the seedClass.
//        resolvedClz.add(seedCls);
//    }
//
//    public static void configure(Kryo kryo) {
//        for (Class cls : resolvedClz) {
//            kryo.register(cls);
//        }
//    }
//
//    public static <R> ClassAccess get(Class<R> cls) {
//        return fieldAccessMap.get(cls);
//    }
//
//    public static class ClassAccess {
//        public final FieldAccess fieldAccess;
//        public final ConstructorAccess constructorAccess;
//        public final Map<String, Integer> fieldIndex;
//
//        public ClassAccess(Class clz) {
//            fieldAccess = FieldAccess.get(clz);
//            constructorAccess = ConstructorAccess.get(clz);
//            fieldIndex = new HashMap<>();
//
//            Field[] fields = clz.getFields();
//            for (Field field : fields) {
//                int modifiers = field.getModifiers();
//                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers))// omit
//                    // static
//                    // and
//                    // final
//                    // field
//                    continue;
//                fieldIndex.put(field.getName(),
//                        fieldAccess.getIndex(field.getName()));
//            }
//        }
//    }
//}
