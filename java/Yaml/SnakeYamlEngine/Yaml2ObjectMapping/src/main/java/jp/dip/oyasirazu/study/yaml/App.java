/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jp.dip.oyasirazu.study.yaml;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.snakeyaml.engine.v1.api.Load;
import org.snakeyaml.engine.v1.api.LoadSettings;
import org.snakeyaml.engine.v1.api.LoadSettingsBuilder;

public class App {

    private static final String KEY_LABEL = "label";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_NEW_TEXT = "newText";

    private Map<String, List<Config>> configs;

    public App() throws IOException {
        // 設定保管用 HashMap 作成
        this.configs = new HashMap<>();

        // YAML ロード用オブジェクト準備
        LoadSettings settings = new LoadSettingsBuilder().build();
        Load load = new Load(settings);

        // resources ディレクトリ内の `Config.yaml` を読み込んで Map として取得
        var config = (Map<String, List<Map<String, String>>>)load.loadFromReader(
                new InputStreamReader(
                    ClassLoader.getSystemResourceAsStream("Config.yaml"),
                    "UTF-8"));

        // 取得した Map から Config オブジェクトに詰め替える
        for (String fileType : config.keySet()) {
            this.configs.putIfAbsent(fileType, new ArrayList<Config>());
            var fileTypeConfigs = this.configs.getOrDefault(fileType, null);

            for (Map<String, String> configSource : config.get(fileType)) {
                fileTypeConfigs.add(
                        new Config(configSource.getOrDefault(KEY_LABEL, ""),
                        configSource.getOrDefault(KEY_DESCRIPTION, ""),
                        configSource.getOrDefault(KEY_NEW_TEXT, "")));
            }
        }
    }

    public void printConfigs() {
        for (String fileType : configs.keySet()) {
            System.out.printf("%s:\n", fileType);
            for (Config config : configs.get(fileType)) {
                System.out.printf("    - %s\n", config);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.printConfigs();
    }
}
