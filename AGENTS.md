# Repository Guidelines

このファイルは AI エージェント向けの **Single Source of Truth** です。
コード生成・レビュー時に必ず従ってください。

## AI エージェントへの指示

- すべての回答は日本語で行うこと。
- コードは授業教材として使用するため、**シンプルさ・可読性を最優先**すること。
- 新しいソースファイルを追加する場合は、既存の章番号と命名規則に合わせること。
- コメントは**日本語**で記述すること。
- **外部ライブラリを導入しないこと**。Java 標準ライブラリのみ使用可。
- 学習用コードの意図を変える最適化や、説明前提を崩すリファクタリングは避けること。

## プロジェクト構成とモジュール

- **言語**: Java（標準ライブラリのみ、外部依存なし）
- **IDE**: IntelliJ IDEA（`.iml` プロジェクト）
- **ビルドツール**: なし（`javac` / `java` で直接コンパイル・実行）
- **ソースルート**: `src/`
- **主な学習内容**: 条件分岐、`switch`、三項演算子、繰り返し、`break`、`continue`

```
src/
├── CalcCircle.java                 # Scanner と例外処理のサンプル
├── ColorEnum.java                  # enum のサンプル
├── ColorEnum2.java                 # 値を持つ enum のサンプル
├── IfTestXX.java                   # if 文の確認コード
├── SampleIfXX.java                 # if 文のサンプル
├── SampleSwitchXX.java             # switch 文のサンプル
├── SampleSwitchBreakXX.java        # switch と break のサンプル
├── SampleSwitchWithEnum.java       # enum と switch のサンプル
├── SampleConditionalXX.java        # 三項演算子のサンプル
├── Test05XX.java                   # 条件分岐の確認問題
└── vol06_02/
    ├── SampleWhileXX.java          # while 文のサンプル
    ├── SampleDoWhileXX.java        # do-while 文のサンプル
    ├── SampleForXX.java            # for 文のサンプル
    ├── SampleBreakXX.java          # break のサンプル
    ├── SampleContinueXX.java       # continue のサンプル
    ├── SampleLabelXX.java          # ラベル付き制御のサンプル
    └── Test05XX.java               # 繰り返しの確認問題
```

## ビルド・テスト・開発コマンド

`src/` 直下のデフォルトパッケージのクラス:

```bash
javac src/<ClassName>.java
java -cp src <ClassName>
```

`vol06_02` パッケージのクラス:

```bash
javac src/vol06_02/<ClassName>.java
java -cp src vol06_02.<ClassName>
```

テストフレームワークは未導入です。
確認は対象ファイルを個別にコンパイル・実行して行います。
この教材には、文法エラーやスコープエラーを確認するために、あえてコンパイルできないファイルも含まれます。
全 Java ファイルの一括コンパイル成功を前提にしないでください。

## コーディング規約と命名

- 各ファイルは原則として `public static void main(String[] args)` を持つ独立したプログラム。
- `src/` 直下はパッケージ宣言なし。
- `src/vol06_02/` 配下は `package vol06_02;` を付ける。
- クラス名とファイル名を一致させる。
- 授業で追いやすいように、複雑な抽象化や過度なメソッド分割は避ける。

| プレフィックス | 用途 | 例 |
|--------------|------|-----|
| `SampleIfXX` | if 文のサンプル | `SampleIf01.java` |
| `IfTestXX` | if 文の確認コード | `IfTest11.java` |
| `SampleSwitchXX` | switch 文のサンプル | `SampleSwitch01.java` |
| `SampleConditionalXX` | 三項演算子のサンプル | `SampleConditional01.java` |
| `SampleWhileXX` | while 文のサンプル | `SampleWhile02.java` |
| `SampleDoWhileXX` | do-while 文のサンプル | `SampleDoWhile01.java` |
| `SampleForXX` | for 文のサンプル | `SampleFor01.java` |
| `SampleBreakXX` | break のサンプル | `SampleBreak01.java` |
| `SampleContinueXX` | continue のサンプル | `SampleContinue01.java` |
| `SampleLabelXX` | ラベル付き制御のサンプル | `SampleLabel01.java` |
| `Test05XX` | 確認問題 | `Test0501.java` |

## 設定・環境

- **JDK**: 11 以上
- **GitHub Actions**:
  - `claude-review.yml` — PR コメントで `@claude` を付けると AI レビュー（要 `ANTHROPIC_API_KEY`）
  - `junie-review.yml` — PR 作成・更新時にレビュー（要 `JUNIE_API_KEY`）

## ドキュメント

- `README.md` : プロジェクト概要と実行方法。
- `TUTORIAL.md` : 授業用テキスト。解説と確認問題。
- `AGENTS.md` : AI エージェント向け共通ルール（本ファイル）。
