# Jec26CMJavaVol06

Java の制御構文を学ぶための授業用プロジェクトです。
ビルドツールは使わず、IntelliJ IDEA または `javac` / `java` で直接コンパイル・実行します。

## NotebookLM 補足資料

https://notebooklm.google.com/notebook/fc30f692-9b4d-473d-a83c-246a7b16c92a

## 必要環境

- **JDK** 11 以上
- **IntelliJ IDEA**（Community Edition 可）

## セットアップ

1. このリポジトリをクローンする
2. IntelliJ IDEA でプロジェクトを開く
3. Project SDK に JDK 11 以上を設定する
4. `src/` をソースルートとして確認する

## 学習内容

このリポジトリでは、主に次の内容を扱います。

- `if` / `else if` / `else` による条件分岐
- 条件式と比較演算子、論理演算子
- `switch` 文と `break`
- enum を使った `switch`
- 三項演算子
- `while` / `do-while` / `for` による繰り返し
- ネストした繰り返し
- `break` / `continue`
- ラベル付き `break` / `continue`

## プロジェクト構成

```
src/
├── CalcCircle.java                 # Scanner と例外処理を使う円の面積計算
├── ColorEnum.java                  # switch 学習用 enum
├── ColorEnum2.java                 # 値を持つ enum
├── IfTestXX.java                   # if 文の確認コード
├── SampleIfXX.java                 # if 文のサンプル
├── SampleSwitchXX.java             # switch 文のサンプル
├── SampleSwitchBreakXX.java        # switch と break のサンプル
├── SampleSwitchWithEnum.java       # enum と switch のサンプル
├── SampleConditional01.java        # 三項演算子のサンプル
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

`src/` 直下のファイルはデフォルトパッケージです。
`src/vol06_02/` 配下のファイルは `package vol06_02;` を持ちます。

## 実行方法

IntelliJ IDEA では、各 Java ファイルの `main` メソッドを右クリックして **Run** を選択します。

この教材には、コンパイルエラーや実行時の違いを確認するためのファイルも含まれています。
全ファイルを一括コンパイルするのではなく、授業で扱うファイルを 1 つずつコンパイル・実行してください。

コマンドラインで `src/` 直下のクラスを実行する場合:

```bash
javac src/SampleIf01.java
java -cp src SampleIf01
```

`vol06_02` パッケージのクラスを実行する場合:

```bash
javac src/vol06_02/SampleFor01.java
java -cp src vol06_02.SampleFor01
```

入力が必要なプログラムの例:

```bash
javac src/CalcCircle.java
java -cp src CalcCircle
```

コンパイルエラーを確認する教材の例:

- `IfTest31.java` : ブロック内で宣言した変数のスコープ
- `IfTest33.java` : 同じスコープでの変数再宣言
- `Test0504.java` : Java では使えない連続比較
- `Test0516.java` : 重複した `case`
- `Test0522.java` : `switch` に使えない型
- `vol06_02/SampleWhile04.java` : ブロック内変数のスコープ
- `vol06_02/Test0548.java` : 未完成の `for` 文

## ファイル命名規則

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

## GitHub Actions

### Claude Code Review

`.github/workflows/claude-review.yml` を使うには、GitHub Secrets の設定が必要です。

1. GitHub のリポジトリ画面で `Settings` → `Secrets and variables` → `Actions` → `New repository secret`
2. Name: `ANTHROPIC_API_KEY`
3. Value: Anthropic の API キー

PR コメントで `@claude` を付けるとレビュー応答が実行されます。

### Junie Code Review

`.github/workflows/junie-review.yml` を使うには、GitHub Secrets の設定が必要です。

1. GitHub のリポジトリ画面で `Settings` → `Secrets and variables` → `Actions` → `New repository secret`
2. Name: `JUNIE_API_KEY`
3. Value: JetBrains Junie の API キー

PR 作成または更新時にレビューが自動実行されます。

## ドキュメント

- `README.md` : プロジェクト概要と実行方法
- `TUTORIAL.md` : 授業用テキスト
- `AGENTS.md` : AI エージェント向け共通ルール

## ライセンス

未設定です。必要に応じて追加してください。
