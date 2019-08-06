package Dynamic03;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 直接粘贴了解即可，对w3c等在线编程适用
 * 动态编译
 * 1. 通过Runtime调用执行类
 * 2. 通过JavaCompiler调用执行类(主要)
 */
public class DynamicCompiler {
    public static void main(String[] args) throws Exception {
        //通过IO流操作，将字符串存储成一个临时文件，然后调用动态编译方法！
        String str = "public class HelloWorld {public static void main(String[] args){System.out.println(\"Hello World!\");}}";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/HelloWorld.java")));
        bw.write(str);
        bw.flush();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "src/resources/HelloWorld.java");
        System.out.println(result==0?"编译成功":"编译失败");

//        通过Runtime调用执行类
//        Runtime run = Runtime.getRuntime();
//        Process process = run.exec("java -cp  c:/myjava    HelloWorld");
//        InputStream in = process.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//        String info = "";
//        while((info=reader.readLine())!=null){
//            System.out.println(info);
//        }

        URL[] urls = new URL[] {new URL("file:/"+"src/resources/")};
        URLClassLoader loader = new URLClassLoader(urls);
        Class c = loader.loadClass("resources.HelloWorld");
        //调用加载类的main方法
        Method m = c.getDeclaredMethod("main",String[].class);
        m.invoke(null, (Object)new String[]{});
        //由于可变参数是JDK5.0之后才有。
        //m.invoke(null, (Object)new String[]{});会编译成:m.invoke(null,"aa","bb"),就发生了参数个数不匹配的问题。
        //因此，必须要加上(Object)转型，避免这个问题。
        //public static void main(String[] args)

    }
}
