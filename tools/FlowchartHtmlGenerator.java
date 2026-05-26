import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlowchartHtmlGenerator {
    private static final Path SOURCE_DIR = Paths.get("docs", "flowcharts");
    private static final Path OUTPUT_DIR = SOURCE_DIR.resolve("html");

    private static final Pattern HEADING_PATTERN = Pattern.compile("^(#{1,6})\\s+(.+)$");
    private static final Pattern UNORDERED_LIST_PATTERN = Pattern.compile("^\\s*-\\s+(.+)$");
    private static final Pattern ORDERED_LIST_PATTERN = Pattern.compile("^\\s*\\d+\\.\\s+(.+)$");
    private static final Pattern CODE_SPAN_PATTERN = Pattern.compile("`([^`]+)`");
    private static final Pattern LINK_PATTERN = Pattern.compile("\\[([^\\]]+)\\]\\(([^)]+)\\)");
    private static final Pattern STRONG_PATTERN = Pattern.compile("\\*\\*([^*]+)\\*\\*");

    public static void main(String[] args) throws IOException {
        if (!Files.isDirectory(SOURCE_DIR)) {
            throw new IOException("Markdown ディレクトリが見つかりません: " + SOURCE_DIR);
        }

        Files.createDirectories(OUTPUT_DIR);
        Files.writeString(OUTPUT_DIR.resolve("style.css"), buildStyleSheet(), StandardCharsets.UTF_8);

        List<Path> markdownFiles;
        try (Stream<Path> stream = Files.list(SOURCE_DIR)) {
            markdownFiles = stream
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().endsWith(".md"))
                    .sorted(FlowchartHtmlGenerator::compareMarkdownFiles)
                    .collect(Collectors.toList());
        }

        for (Path markdownFile : markdownFiles) {
            List<String> lines = Files.readAllLines(markdownFile, StandardCharsets.UTF_8);
            String title = findTitle(lines, removeExtension(markdownFile.getFileName().toString()));
            String body = new MarkdownRenderer().render(lines);
            boolean indexPage = markdownFile.getFileName().toString().equals("INDEX.md");
            Path outputFile = OUTPUT_DIR.resolve(toHtmlFileName(markdownFile.getFileName().toString()));
            Files.writeString(outputFile, buildHtmlPage(title, body, markdownFile, indexPage), StandardCharsets.UTF_8);
            System.out.println(outputFile);
        }
    }

    private static int compareMarkdownFiles(Path left, Path right) {
        String leftName = left.getFileName().toString();
        String rightName = right.getFileName().toString();
        if (leftName.equals("INDEX.md")) {
            return rightName.equals("INDEX.md") ? 0 : -1;
        }
        if (rightName.equals("INDEX.md")) {
            return 1;
        }
        return leftName.compareTo(rightName);
    }

    private static String findTitle(List<String> lines, String fallback) {
        for (String line : lines) {
            Matcher matcher = HEADING_PATTERN.matcher(line);
            if (matcher.matches() && matcher.group(1).length() == 1) {
                return stripInlineMarkdown(matcher.group(2));
            }
        }
        return fallback;
    }

    private static String buildHtmlPage(String title, String body, Path markdownFile, boolean indexPage) {
        String sourceFileName = markdownFile.getFileName().toString();
        StringBuilder html = new StringBuilder();
        html.append("<!doctype html>\n");
        html.append("<html lang=\"ja\">\n");
        html.append("<head>\n");
        html.append("  <meta charset=\"UTF-8\">\n");
        html.append("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
        html.append("  <title>").append(escapeHtml(title)).append("</title>\n");
        html.append("  <link rel=\"stylesheet\" href=\"style.css\">\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("  <!-- このファイルは tools/FlowchartHtmlGenerator.java で生成しています。 -->\n");
        html.append("  <header class=\"page-header\">\n");
        html.append("    <div class=\"page-header__inner\">\n");
        if (indexPage) {
            html.append("      <span class=\"page-header__current\">フローチャート目次</span>\n");
        } else {
            html.append("      <a class=\"page-header__link\" href=\"index.html\">目次へ戻る</a>\n");
        }
        html.append("      <a class=\"page-header__source\" href=\"../")
                .append(escapeAttribute(sourceFileName))
                .append("\">元の Markdown: ")
                .append(escapeHtml(sourceFileName))
                .append("</a>\n");
        html.append("    </div>\n");
        html.append("  </header>\n");
        html.append("  <main class=\"markdown-body\">\n");
        html.append(body);
        html.append("  </main>\n");
        html.append("  <script src=\"https://cdn.jsdelivr.net/npm/mermaid@10/dist/mermaid.min.js\"></script>\n");
        html.append("  <script>\n");
        html.append("    if (window.mermaid) {\n");
        html.append("      mermaid.initialize({ startOnLoad: true, securityLevel: 'loose' });\n");
        html.append("    }\n");
        html.append("  </script>\n");
        html.append("</body>\n");
        html.append("</html>\n");
        return html.toString();
    }

    private static String buildStyleSheet() {
        return String.join("\n",
                "body {",
                "  margin: 0;",
                "  color: #24292f;",
                "  background: #ffffff;",
                "  font-family: -apple-system, BlinkMacSystemFont, \"Hiragino Sans\", \"Yu Gothic\", Meiryo, sans-serif;",
                "  line-height: 1.7;",
                "}",
                "",
                "a {",
                "  color: #0969da;",
                "  text-decoration: none;",
                "}",
                "",
                "a:hover {",
                "  text-decoration: underline;",
                "}",
                "",
                ".page-header {",
                "  border-bottom: 1px solid #d0d7de;",
                "  background: #f6f8fa;",
                "}",
                "",
                ".page-header__inner {",
                "  display: flex;",
                "  flex-wrap: wrap;",
                "  gap: 8px 20px;",
                "  justify-content: space-between;",
                "  max-width: 1040px;",
                "  margin: 0 auto;",
                "  padding: 12px 20px;",
                "  font-size: 14px;",
                "}",
                "",
                ".page-header__current {",
                "  font-weight: 700;",
                "}",
                "",
                ".markdown-body {",
                "  max-width: 1040px;",
                "  margin: 0 auto;",
                "  padding: 32px 20px 56px;",
                "}",
                "",
                ".markdown-body h1,",
                ".markdown-body h2,",
                ".markdown-body h3 {",
                "  line-height: 1.3;",
                "}",
                "",
                ".markdown-body h1 {",
                "  margin: 0 0 24px;",
                "  padding-bottom: 12px;",
                "  border-bottom: 1px solid #d8dee4;",
                "  font-size: 32px;",
                "}",
                "",
                ".markdown-body h2 {",
                "  margin: 32px 0 16px;",
                "  padding-bottom: 8px;",
                "  border-bottom: 1px solid #d8dee4;",
                "  font-size: 24px;",
                "}",
                "",
                ".markdown-body h3 {",
                "  margin: 24px 0 12px;",
                "  font-size: 19px;",
                "}",
                "",
                ".markdown-body p,",
                ".markdown-body ul,",
                ".markdown-body ol,",
                ".markdown-body blockquote,",
                ".markdown-body table,",
                ".markdown-body pre {",
                "  margin-top: 0;",
                "  margin-bottom: 16px;",
                "}",
                "",
                ".markdown-body ul,",
                ".markdown-body ol {",
                "  padding-left: 1.7em;",
                "}",
                "",
                ".markdown-body code {",
                "  padding: 0.15em 0.35em;",
                "  border-radius: 4px;",
                "  background: #f6f8fa;",
                "  font-family: ui-monospace, SFMono-Regular, Consolas, \"Liberation Mono\", Menlo, monospace;",
                "  font-size: 0.92em;",
                "}",
                "",
                ".markdown-body pre {",
                "  overflow-x: auto;",
                "  padding: 16px;",
                "  border: 1px solid #d0d7de;",
                "  border-radius: 6px;",
                "  background: #f6f8fa;",
                "}",
                "",
                ".markdown-body pre code {",
                "  display: block;",
                "  padding: 0;",
                "  border-radius: 0;",
                "  background: transparent;",
                "  font-size: 14px;",
                "  line-height: 1.55;",
                "}",
                "",
                ".markdown-body pre.mermaid {",
                "  background: #ffffff;",
                "  text-align: center;",
                "}",
                "",
                ".markdown-body pre.mermaid svg {",
                "  max-width: 100%;",
                "  height: auto;",
                "}",
                "",
                ".markdown-body table {",
                "  display: block;",
                "  width: 100%;",
                "  overflow-x: auto;",
                "  border-spacing: 0;",
                "  border-collapse: collapse;",
                "}",
                "",
                ".markdown-body th,",
                ".markdown-body td {",
                "  padding: 6px 10px;",
                "  border: 1px solid #d0d7de;",
                "  vertical-align: top;",
                "}",
                "",
                ".markdown-body th {",
                "  background: #f6f8fa;",
                "  font-weight: 700;",
                "}",
                "",
                ".markdown-body blockquote {",
                "  margin-left: 0;",
                "  padding: 8px 16px;",
                "  border-left: 4px solid #d0d7de;",
                "  color: #57606a;",
                "}",
                "",
                ".markdown-body hr {",
                "  height: 1px;",
                "  margin: 28px 0;",
                "  border: 0;",
                "  background: #d8dee4;",
                "}",
                "",
                "@media (max-width: 640px) {",
                "  .markdown-body {",
                "    padding: 24px 14px 44px;",
                "  }",
                "",
                "  .markdown-body h1 {",
                "    font-size: 26px;",
                "  }",
                "",
                "  .markdown-body h2 {",
                "    font-size: 21px;",
                "  }",
                "}",
                "");
    }

    private static String toHtmlFileName(String markdownFileName) {
        if (markdownFileName.equals("INDEX.md")) {
            return "index.html";
        }
        return removeExtension(markdownFileName) + ".html";
    }

    private static String removeExtension(String fileName) {
        int index = fileName.lastIndexOf('.');
        if (index == -1) {
            return fileName;
        }
        return fileName.substring(0, index);
    }

    private static String stripInlineMarkdown(String text) {
        String result = LINK_PATTERN.matcher(text).replaceAll("$1");
        result = result.replace("**", "");
        result = result.replace("`", "");
        return result;
    }

    private static String escapeHtml(String text) {
        StringBuilder escaped = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            switch (ch) {
                case '&':
                    escaped.append("&amp;");
                    break;
                case '<':
                    escaped.append("&lt;");
                    break;
                case '>':
                    escaped.append("&gt;");
                    break;
                case '"':
                    escaped.append("&quot;");
                    break;
                default:
                    escaped.append(ch);
                    break;
            }
        }
        return escaped.toString();
    }

    private static String escapeAttribute(String text) {
        return escapeHtml(text);
    }

    private static class MarkdownRenderer {
        private int sectionCount = 1;

        String render(List<String> lines) {
            StringBuilder html = new StringBuilder();
            List<String> paragraph = new ArrayList<>();
            String openListTag = null;

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);

                if (line.startsWith("```")) {
                    appendParagraph(html, paragraph);
                    openListTag = closeList(html, openListTag);
                    String language = line.substring(3).trim();
                    List<String> codeLines = new ArrayList<>();
                    i++;
                    while (i < lines.size() && !lines.get(i).startsWith("```")) {
                        codeLines.add(lines.get(i));
                        i++;
                    }
                    appendCodeBlock(html, language, codeLines);
                    continue;
                }

                if (line.trim().isEmpty()) {
                    appendParagraph(html, paragraph);
                    openListTag = closeList(html, openListTag);
                    continue;
                }

                if (isHorizontalRule(line)) {
                    appendParagraph(html, paragraph);
                    openListTag = closeList(html, openListTag);
                    html.append("    <hr>\n");
                    continue;
                }

                Matcher headingMatcher = HEADING_PATTERN.matcher(line);
                if (headingMatcher.matches()) {
                    appendParagraph(html, paragraph);
                    openListTag = closeList(html, openListTag);
                    int level = headingMatcher.group(1).length();
                    String text = headingMatcher.group(2);
                    String id = "section-" + sectionCount++;
                    html.append("    <h").append(level).append(" id=\"").append(id).append("\">")
                            .append(renderInline(text))
                            .append("</h").append(level).append(">\n");
                    continue;
                }

                if (line.startsWith(">")) {
                    appendParagraph(html, paragraph);
                    openListTag = closeList(html, openListTag);
                    List<String> quoteLines = new ArrayList<>();
                    while (i < lines.size() && lines.get(i).startsWith(">")) {
                        String quoteLine = lines.get(i).substring(1);
                        if (quoteLine.startsWith(" ")) {
                            quoteLine = quoteLine.substring(1);
                        }
                        quoteLines.add(quoteLine);
                        i++;
                    }
                    i--;
                    appendBlockquote(html, quoteLines);
                    continue;
                }

                if (isTableStart(lines, i)) {
                    appendParagraph(html, paragraph);
                    openListTag = closeList(html, openListTag);
                    List<String> tableLines = new ArrayList<>();
                    while (i < lines.size() && isTableRow(lines.get(i))) {
                        tableLines.add(lines.get(i));
                        i++;
                    }
                    i--;
                    appendTable(html, tableLines);
                    continue;
                }

                Matcher unorderedMatcher = UNORDERED_LIST_PATTERN.matcher(line);
                if (unorderedMatcher.matches()) {
                    appendParagraph(html, paragraph);
                    if (!"ul".equals(openListTag)) {
                        openListTag = closeList(html, openListTag);
                        html.append("    <ul>\n");
                        openListTag = "ul";
                    }
                    html.append("      <li>").append(renderInline(unorderedMatcher.group(1))).append("</li>\n");
                    continue;
                }

                Matcher orderedMatcher = ORDERED_LIST_PATTERN.matcher(line);
                if (orderedMatcher.matches()) {
                    appendParagraph(html, paragraph);
                    if (!"ol".equals(openListTag)) {
                        openListTag = closeList(html, openListTag);
                        html.append("    <ol>\n");
                        openListTag = "ol";
                    }
                    html.append("      <li>").append(renderInline(orderedMatcher.group(1))).append("</li>\n");
                    continue;
                }

                openListTag = closeList(html, openListTag);
                paragraph.add(line.trim());
            }

            appendParagraph(html, paragraph);
            closeList(html, openListTag);
            return html.toString();
        }

        private static void appendParagraph(StringBuilder html, List<String> paragraph) {
            if (paragraph.isEmpty()) {
                return;
            }
            html.append("    <p>")
                    .append(renderInline(String.join(" ", paragraph)))
                    .append("</p>\n");
            paragraph.clear();
        }

        private static String closeList(StringBuilder html, String openListTag) {
            if (openListTag == null) {
                return null;
            }
            html.append("    </").append(openListTag).append(">\n");
            return null;
        }

        private static void appendCodeBlock(StringBuilder html, String language, List<String> codeLines) {
            String code = String.join("\n", codeLines);
            if ("mermaid".equals(language)) {
                html.append("    <pre class=\"mermaid\">")
                        .append(escapeHtml(code))
                        .append("</pre>\n");
                return;
            }

            html.append("    <pre><code");
            if (!language.isEmpty()) {
                html.append(" class=\"language-").append(escapeAttribute(language)).append("\"");
            }
            html.append(">")
                    .append(escapeHtml(code))
                    .append("</code></pre>\n");
        }

        private static void appendBlockquote(StringBuilder html, List<String> quoteLines) {
            html.append("    <blockquote>\n");
            html.append("      <p>");
            for (int i = 0; i < quoteLines.size(); i++) {
                if (i > 0) {
                    html.append("<br>");
                }
                html.append(renderInline(quoteLines.get(i)));
            }
            html.append("</p>\n");
            html.append("    </blockquote>\n");
        }

        private static void appendTable(StringBuilder html, List<String> tableLines) {
            if (tableLines.size() < 2) {
                return;
            }

            List<String> headerCells = splitTableRow(tableLines.get(0));
            html.append("    <table>\n");
            html.append("      <thead>\n");
            html.append("        <tr>");
            for (String cell : headerCells) {
                html.append("<th>").append(renderInline(cell)).append("</th>");
            }
            html.append("</tr>\n");
            html.append("      </thead>\n");
            html.append("      <tbody>\n");

            for (int i = 2; i < tableLines.size(); i++) {
                List<String> cells = splitTableRow(tableLines.get(i));
                html.append("        <tr>");
                for (String cell : cells) {
                    html.append("<td>").append(renderInline(cell)).append("</td>");
                }
                html.append("</tr>\n");
            }

            html.append("      </tbody>\n");
            html.append("    </table>\n");
        }

        private static boolean isHorizontalRule(String line) {
            String trimmed = line.trim();
            return trimmed.length() >= 3 && trimmed.chars().allMatch(ch -> ch == '-');
        }

        private static boolean isTableStart(List<String> lines, int index) {
            return index + 1 < lines.size()
                    && isTableRow(lines.get(index))
                    && isTableSeparator(lines.get(index + 1));
        }

        private static boolean isTableRow(String line) {
            String trimmed = line.trim();
            return trimmed.startsWith("|") && trimmed.endsWith("|");
        }

        private static boolean isTableSeparator(String line) {
            String trimmed = line.trim();
            if (!isTableRow(trimmed)) {
                return false;
            }
            for (int i = 0; i < trimmed.length(); i++) {
                char ch = trimmed.charAt(i);
                if (ch != '|' && ch != '-' && ch != ':' && ch != ' ') {
                    return false;
                }
            }
            return trimmed.contains("---");
        }

        private static List<String> splitTableRow(String line) {
            String trimmed = line.trim();
            if (trimmed.startsWith("|")) {
                trimmed = trimmed.substring(1);
            }
            if (trimmed.endsWith("|")) {
                trimmed = trimmed.substring(0, trimmed.length() - 1);
            }
            String[] parts = trimmed.split("\\|", -1);
            List<String> cells = new ArrayList<>();
            for (String part : parts) {
                cells.add(part.trim());
            }
            return cells;
        }

        private static String renderInline(String rawText) {
            Map<String, String> codeReplacements = new LinkedHashMap<>();
            Map<String, String> linkReplacements = new LinkedHashMap<>();

            String text = protectCodeSpans(rawText, codeReplacements);
            text = protectLinks(text, linkReplacements);
            text = escapeHtml(text);
            text = renderStrong(text);

            for (Map.Entry<String, String> entry : linkReplacements.entrySet()) {
                text = text.replace(entry.getKey(), entry.getValue());
            }
            for (Map.Entry<String, String> entry : codeReplacements.entrySet()) {
                text = text.replace(entry.getKey(), entry.getValue());
            }
            return text;
        }

        private static String protectCodeSpans(String rawText, Map<String, String> replacements) {
            Matcher matcher = CODE_SPAN_PATTERN.matcher(rawText);
            StringBuffer buffer = new StringBuffer();
            while (matcher.find()) {
                String token = "\u0001CODE" + replacements.size() + "\u0002";
                replacements.put(token, "<code>" + escapeHtml(matcher.group(1)) + "</code>");
                matcher.appendReplacement(buffer, Matcher.quoteReplacement(token));
            }
            matcher.appendTail(buffer);
            return buffer.toString();
        }

        private static String protectLinks(String rawText, Map<String, String> replacements) {
            Matcher matcher = LINK_PATTERN.matcher(rawText);
            StringBuffer buffer = new StringBuffer();
            while (matcher.find()) {
                String token = "\u0001LINK" + replacements.size() + "\u0002";
                String label = renderStrong(escapeHtml(matcher.group(1)));
                String href = adjustMarkdownHref(matcher.group(2));
                replacements.put(token, "<a href=\"" + escapeAttribute(href) + "\">" + label + "</a>");
                matcher.appendReplacement(buffer, Matcher.quoteReplacement(token));
            }
            matcher.appendTail(buffer);
            return buffer.toString();
        }

        private static String renderStrong(String escapedText) {
            Matcher matcher = STRONG_PATTERN.matcher(escapedText);
            StringBuffer buffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(
                        buffer,
                        Matcher.quoteReplacement("<strong>" + matcher.group(1) + "</strong>"));
            }
            matcher.appendTail(buffer);
            return buffer.toString();
        }

        private static String adjustMarkdownHref(String href) {
            String prefix = "";
            String markdownPath = href;
            if (markdownPath.startsWith("./")) {
                prefix = "";
                markdownPath = markdownPath.substring(2);
            }
            if (markdownPath.endsWith(".md")) {
                String baseName = markdownPath.substring(0, markdownPath.length() - 3);
                if (baseName.equals("INDEX")) {
                    return prefix + "index.html";
                }
                return prefix + baseName + ".html";
            }
            return href;
        }
    }
}
