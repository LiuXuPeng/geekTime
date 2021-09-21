import java.net.URL;

/*
javac
base64 hello.class
 */

public class JvmClassLoaderPrintPath {

    public static void main(String[] args) {
        //URL类加载器？？？
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();

        for (URL url :urls){
            System.out.println(url.toExternalForm());
        }
        System.out.println(JvmClassLoaderPrintPath.class.getClassLoader().getParent());
        System.out.println(JvmClassLoaderPrintPath.class.getClassLoader());
    }
}
