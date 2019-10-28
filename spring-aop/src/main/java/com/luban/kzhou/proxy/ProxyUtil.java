package com.luban.kzhou.proxy;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ProxyUtil  {

    /**
     * package com.luban.kzhou.proxy;
     *
     * public class LogProxy implements IndexService{
     *     private IndexService indexService;
     *     private MyInvocationHandler p;
     *     public LogProxy(IndexService indexService,MyInvocationHandler p){
     *         this.indexService = indexService;
     *         this.p = p;
     *     }
     *
     *     public String query(String id) {
     *         p.process();
     *         String name = indexService.query(id);
     *         return name ;
     *     }
     * }
     * 可以代理一切对象，设计为静态方法
     * @param target 目标对象
     * @return   代理对象
     */
    public static Object newInstance(Object target,MyInvocationHandler myInvocationHandler){
        Object proxy = null;//代理对象
        //代理和目标都实现了接口，面向接口编程，不需要具体的实现类信息
        //接口的信息已经完全够用了
        Class targetInfo = target.getClass().getInterfaces()[0];
        //获取接口中所有方法
        Method methods[] = targetInfo.getDeclaredMethods();
        String infName = targetInfo.getSimpleName();
        //建议使用StringBuffer
        //StringBuffer sb = new StringBuffer();
        String line = "\n";
        String tab = "\t";
        String packageLine = "package com.google;"+line;
        String importLine = "import "+targetInfo.getName()+";"+line;
        String importLine2 = "import "+myInvocationHandler.getClass().getInterfaces()[0].getName()+";"+line;
        String firstLine = "public class $Proxy implements "+infName+"{"+line;
        String fieldLine= tab+"private "+infName+" target;"+line;
        String fieldline2 = tab+"private MyInvocationHandler p;"+line;
        String constructorLine = tab+"public $Proxy("+infName+" target,MyInvocationHandler p){"+line
                +tab+tab+"this.target = target;"+line
                +tab+tab+"this.p = p;"+line
                +"}"+line;
        String methodLine = "";
        for (Method m:methods) {
            String returnTypeName = m.getReturnType().getSimpleName();
            String methodName = m.getName();
            Class params[] = m.getParameterTypes();
            String parmasLine = "";
            String arges = "";
            for (int i = 0; i <params.length ; i++) {
                parmasLine+=params[i].getSimpleName()+" p"+i+",";
                arges += "p"+i+",";
            }
            if(packageLine.length()>0){
                parmasLine = parmasLine.substring(0,parmasLine.length()-1);
                arges = arges.substring(0,arges.length()-1);
            }
            String invokeMethodLine = "";
            String returnLine = "";
            //判断是否需要返回值
            if(returnTypeName.equals("void")){
                invokeMethodLine = tab+tab+"target."+methodName+"("+arges+");";
            }else {
                invokeMethodLine = tab+tab+returnTypeName+" object = "+"target."+methodName+"("+arges+");";
                returnLine = tab+tab+"return object;";
            }
            methodLine += tab+"public "+returnTypeName+" "+methodName+"("+parmasLine+"){"+line
                //+tab+tab+"System.out.println(\"-------------log-------------\");"+line
                  +tab+tab+"p.process();"+line
                +invokeMethodLine+line
                +returnLine+"}"+line;
        }
        //生成代码
        String code = packageLine+importLine+importLine2+firstLine+fieldline2+fieldLine+constructorLine+methodLine+line+"}";
        //将代码写到磁盘上
        File file =new File("d:\\com\\google\\$Proxy.java");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            fw.write(code);
            fw.flush();
            fw.close();
            //动态将.java---->>编译为.class 借助动态编译工具javaCompiler
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileMgr.getJavaFileObjects(file);
            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
            t.call();
            fileMgr.close();
            //URL 类加载器，将.class加载到JVM之中
            URL[] urls = new URL[]{new URL("file:D:\\\\")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("com.google.$Proxy");
            Constructor constructor = clazz.getConstructor(targetInfo,myInvocationHandler.getClass().getInterfaces()[0]);
            proxy = constructor.newInstance(target,myInvocationHandler);
        }catch (Exception e){
            e.printStackTrace();
        }

        return proxy;
    }
}
