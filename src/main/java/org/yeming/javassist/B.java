package org.yeming.javassist;

import javassist.*;

/**
 * Author:yaoalong.
 * Date:2016/4/1.
 * Email:yaoalong@foxmail.com
 */
public class B {

    public static void main(String args[]) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
        CtClass ctClass= ClassPool.getDefault().get("org.yeming.javassist.A");

        String mname="method";
        CtMethod ctMethod=ctClass.getDeclaredMethod(mname);
        String nname=mname+"$impl";
        ctMethod.setName(nname);

        CtMethod mnew= CtNewMethod.copy(ctMethod,mname,ctClass,null);
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("{\nlong start=System.currentTimeMillis();\n");
        stringBuffer.append(nname+"($$);\n");
        stringBuffer.append("System.out.println(\"Call to method "
                + mname
                + " took \" +\n (System.currentTimeMillis()-start) + "
                + "\" ms.\");\n");
        stringBuffer.append("}");
        mnew.setBody(stringBuffer.toString());
        ctClass.addMethod(mnew);
        A a=(A)ctClass.toClass().newInstance();
        a.method();
    }
}
