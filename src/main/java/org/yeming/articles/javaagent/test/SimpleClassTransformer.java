package org.yeming.articles.javaagent.test;
//
//import jdk.internal.org.objectweb.asm.ClassReader;
//import jdk.internal.org.objectweb.asm.tree.ClassNode;
//import jdk.internal.org.objectweb.asm.tree.MethodNode;
//
//import java.io.IOException;
//import java.lang.instrument.ClassFileTransformer;
//import java.lang.instrument.IllegalClassFormatException;
//import java.security.ProtectionDomain;
//import java.util.List;
//
///**
// * Author:yaoalong.
// * Date:2016/3/30.
// * Email:yaoalong@foxmail.com
// */
//public class SimpleClassTransformer implements ClassFileTransformer {
//    @Override
//    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
//        System.out.println("Processing class " + className);
//        String normalizedClassName = className.replaceAll("/", ".");
//
//        ClassReader classReader = null;
//
//        try {
//
//            classReader = new ClassReader(normalizedClassName);
//
//        } catch (IOException e1) {
//
//            e1.printStackTrace();
//
//        }
//
//
//        ClassNode classNode = new ClassNode();
//
//        classReader.accept(classNode, ClassReader.SKIP_DEBUG);
//
//
//        List<MethodNode> allMethods = classNode.methods;
//
//        for (MethodNode methodNode : allMethods) {
//
//            System.out.println(methodNode.name);
//
//        }
//
//        return classfileBuffer;
//
//    }
//}
public class SimpleClassTransformer{

}
