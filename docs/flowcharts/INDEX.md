# フローチャート・トレース表 目次

`src/` 配下の各 Java ファイルに対応するフローチャート（Mermaid 形式）と処理トレース表を、本ディレクトリ配下に 1 ファイルずつ作成しています。

- 対象ファイル数: 108 ファイル（`src/`直下 42 + `src/vol06_02/` 配下 66）
- 各ドキュメントの章構成:
  1. 対象ファイル・パッケージ・テーマ
  2. ソースの要点
  3. フローチャート（Mermaid `flowchart TD`）
  4. トレース表
  5. 実行結果（標準出力）
  6. 学習ポイント

> **注意**: 教材の一部にはコンパイルエラーや文法ミスをあえて含むファイルがあります。該当ファイルの .md には「学習ポイント」欄にその旨を明示しています。

---

## 1. 条件分岐・switch（src/ 直下）

### Scanner と例外処理

- [CalcCircle](./CalcCircle.md) — Scanner で半径を読み、円の面積を計算するサンプル。

### enum

- [ColorEnum](./ColorEnum.md) — enum の基本。
- [ColorEnum2](./ColorEnum2.md) — 値を持つ enum。

### if 文サンプル

- [SampleIf01](./SampleIf01.md) — if の基本形。
- [SampleIf02](./SampleIf02.md) — if / else。
- [SampleIf03](./SampleIf03.md) — if / else if / else の多分岐。

### if 文 確認コード（IfTest）

- [IfTest11](./IfTest11.md)
- [IfTest12](./IfTest12.md)
- [IfTest13](./IfTest13.md)
- [IfTest14](./IfTest14.md)
- [IfTest15](./IfTest15.md)
- [IfTest21](./IfTest21.md)
- [IfTest22](./IfTest22.md)
- [IfTest23](./IfTest23.md)
- [IfTest31](./IfTest31.md)
- [IfTest32](./IfTest32.md)
- [IfTest33](./IfTest33.md)

### 三項演算子

- [SampleConditional01](./SampleConditional01.md) — 三項演算子の基本。

### switch 文

- [SampleSwitch01](./SampleSwitch01.md) — switch の基本。
- [SampleSwitch02](./SampleSwitch02.md) — switch（複数パターン）。
- [SampleSwitchBreak01_](./SampleSwitchBreak01_.md) — break 省略時の fall-through 比較用。
- [SampleSwitchBreak01](./SampleSwitchBreak01.md) — break 有りの正しい例。
- [SampleSwitchBreak02](./SampleSwitchBreak02.md) — break と default。
- [SampleSwitchWithEnum](./SampleSwitchWithEnum.md) — enum を switch で扱う。

### 条件分岐の確認問題

- [Test0501](./Test0501.md)
- [Test0502](./Test0502.md)
- [Test0503](./Test0503.md)
- [Test0504](./Test0504.md)
- [Test0505](./Test0505.md)
- [Test0506](./Test0506.md)
- [Test0507](./Test0507.md)
- [Test0508](./Test0508.md)
- [Test0509](./Test0509.md)
- [Test0510](./Test0510.md)
- [Test0511](./Test0511.md)
- [Test0512](./Test0512.md)
- [Test0513](./Test0513.md)
- [Test0514](./Test0514.md)
- [Test0515](./Test0515.md)
- [Test0516](./Test0516.md)
- [Test0517](./Test0517.md)
- [Test0518](./Test0518.md)
- [Test0519](./Test0519.md)
- [Test0520](./Test0520.md)
- [Test0521](./Test0521.md)
- [Test0522](./Test0522.md)

---

## 2. 繰り返し（src/vol06_02/）

### while 文

- [SampleWhile01a](./SampleWhile01a.md) — while を使わず逐次記述した比較用。
- [SampleWhile01b](./SampleWhile01b.md) — SampleWhile01a を while で書き換えた版。
- [SampleWhile02](./SampleWhile02.md)
- [SampleWhile03](./SampleWhile03.md)
- [SampleWhile04](./SampleWhile04.md) — ※スコープエラーを含む教材。

### do-while 文

- [SampleDoWhile01](./SampleDoWhile01.md)
- [SampleDoWhile02](./SampleDoWhile02.md)

### for 文

- [SampleFor01](./SampleFor01.md)
- [SampleFor02](./SampleFor02.md)
- [SampleFor03](./SampleFor03.md) — 二重 for。
- [SampleFor03a](./SampleFor03a.md)
- [SampleFor03b](./SampleFor03b.md)
- [SampleFor03c](./SampleFor03c.md)
- [SampleFor03d](./SampleFor03d.md)
- [SampleFor03e](./SampleFor03e.md) — 無限ループ。
- [SampleFor03f](./SampleFor03f.md)
- [SampleFor03g](./SampleFor03g.md) — 無限ループ。

### break / continue / label

- [SampleBreak01](./SampleBreak01.md)
- [SampleBreak02](./SampleBreak02.md)
- [SampleBreak03](./SampleBreak03.md)
- [SampleBreak04](./SampleBreak04.md)
- [SampleContinue01](./SampleContinue01.md)
- [SampleContinue02](./SampleContinue02.md)
- [SampleContinue03](./SampleContinue03.md)
- [SampleLabel01](./SampleLabel01.md)
- [SampleLabel02](./SampleLabel02.md)
- [SampleLabel03](./SampleLabel03.md)
- [SampleLabel04](./SampleLabel04.md)

### 繰り返しの確認問題

- [Test0530](./Test0530.md)
- [Test0531](./Test0531.md)
- [Test0532](./Test0532.md)
- [Test0533](./Test0533.md)
- [Test0534](./Test0534.md)
- [Test0535](./Test0535.md)
- [Test0536](./Test0536.md)
- [Test0537](./Test0537.md)
- [Test0538](./Test0538.md)
- [Test0539](./Test0539.md)
- [Test0540](./Test0540.md) — ※`while(1)` コンパイルエラーを含む。
- [Test0541](./Test0541.md)
- [Test0542](./Test0542.md)
- [Test0543](./Test0543.md)
- [Test0544](./Test0544.md)
- [Test0545](./Test0545.md)
- [Test0546](./Test0546.md)
- [Test0547](./Test0547.md) — ※コンパイルエラー含み。
- [Test0548](./Test0548.md) — ※コンパイルエラー含み。
- [Test0549](./Test0549.md)
- [Test0550](./Test0550.md)
- [Test0551](./Test0551.md) — 二重ループ。
- [Test0552](./Test0552.md) — 二重ループ。
- [Test0553](./Test0553.md) — 二重ループ。
- [Test0554](./Test0554.md) — ※コンパイルエラー含み。
- [Test0555](./Test0555.md)
- [Test0556](./Test0556.md)
- [Test0557](./Test0557.md)
- [Test0558](./Test0558.md)
- [Test0559](./Test0559.md)
- [Test0560](./Test0560.md)
- [Test0561](./Test0561.md) — 二重ループ。
- [Test0562](./Test0562.md) — `||` の短絡評価。
- [Test0563](./Test0563.md) — `&&` の短絡評価。

---

## 図の表示について

各 .md は GitHub・IntelliJ IDEA・VS Code の Markdown プレビューで Mermaid 図がそのまま描画されます。Mermaid を解釈しない環境では、コードブロックの定義文を読むことでフロー構造を把握できます。

HTML 版は `docs/flowcharts/html/index.html` から確認できます。
再生成する場合は、リポジトリ直下で次のコマンドを実行します。

```bash
javac -encoding UTF-8 -d /tmp/flowchart-html-build tools/FlowchartHtmlGenerator.java
java -cp /tmp/flowchart-html-build FlowchartHtmlGenerator
```
