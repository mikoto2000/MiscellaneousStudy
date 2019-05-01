/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jp.dip.oyasirazu.study.yaml.jackson.firststep;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class App {
    public static String getYamlString() {
        return "root:\n"
            + "  child1:\n"
            + "    key: 'key1'\n"
            + "    value: 'value1'\n"
            + "  child2:\n"
            + "    key: 'key2'\n"
            + "    value: 'value2'\n";
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        var mapper = new ObjectMapper(new YAMLFactory());
        var test = mapper.readValue(App.getYamlString(), Map.class);

        // java.util.LinkedHashMap
        System.out.printf("test.getClass(): %s\n", test.getClass());

        // {root={child1={key=key1, value=value1}, child2={key=key2, value=value2}}}
        System.out.printf("test: %s\n", test);

        // {child1={key=key1, value=value1}, child2={key=key2, value=value2}}
        var root = (Map<String, Object>)test.get("root");
        System.out.printf("root: %s\n", root);

        // {key=key1, value=value1}
        var child1 = (Map<String, Object>)root.get("child1");
        System.out.printf("child1: %s\n", child1);

        // value1
        System.out.printf("value: %s\n", child1.get("value"));
    }
}
