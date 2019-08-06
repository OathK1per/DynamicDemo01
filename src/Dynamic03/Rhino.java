package Dynamic03;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 脚本引擎javascript API的一个具体实现类Rhino，执行js代码
 */
public class Rhino {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

        //定义变量，js与java均可获取
        engine.put("msg", "this is a script engine learning file");
        String str = "var user = {name : \"aaa\", age : 88, city : [\"cd\", \"xa\"]};";
        str += "print(user.city);";

        //执行脚本，可以在中间被js与java操作
        engine.eval(str);
        engine.eval("msg = \"now I have changed my mind\";");
        Object msg = engine.get("msg");
        System.out.println(msg);

        //定义函数
        engine.eval("function change(a, b) {if (a > b) {var tem = a; a = b; b = tem;} return a;}");
        //取得调用接口
        Invocable invocable = (Invocable) engine;
        //执行脚本中定义的方法
        Object change = invocable.invokeFunction("change", 9, 4);
        System.out.println(change);

        //调用执行js文件，使用类加载器
        URL url = Rhino.class.getClassLoader().getResource("resources/a.js");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        engine.eval(br);
    }
}
