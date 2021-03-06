package jp.dip.oyasirazu.study.yaml.yaml2objectmapping;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Config
 */
public class MapListConfig {
    private List<Snippet> snippets;

    public void setSnippets(List<Snippet> snippets) {
        this.snippets = snippets;
    }

    public List<Snippet> getSnippets() {
        return snippets;
    }

    public String toString() {
        return snippets.toString();
    }

    public static class Snippet {
        private String label;
        private String description;
        private String newText;

        public void setLabel(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setNewText(String newText) {
            this.newText = newText;
        }

        public String getNewText() {
            return newText;
        }

        public String toString() {
            return String.format("{label: %s, description: %s, newText: %s}", label, description, newText);
        }
    }
}

