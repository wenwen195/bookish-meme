package Util;

/**
 * Created by huanganna on 16/3/20.
 */
public class TestNew {
    public static void main(String[] args) throws Exception{
        ConfigReader reader = new ConfigReader("conf.json");
        Conf conf = reader.readConf();
        System.out.println(conf.getHost()+" "+conf.getPort());
    }

}