# SampleSwitch01 — フローチャートとトレース表

- 対象ファイル: `src/SampleSwitch01.java`
- パッケージ: デフォルト
- テーマ: `switch` 文の基本と、`break` がないときの fall-through を学ぶ。

## ソースの要点

```java
int x = 2;
switch (x) {
    case 1:
        System.out.println("One");
    case 2:
        System.out.println("Two");
    case 3:
        System.out.println("Three");
}
```

## フローチャート

```mermaid
flowchart TD
    A([開始]) --> B["x = 2"]
    B --> C{"x の値"}
    C -- "1" --> D["One を出力"]
    C -- "2" --> E["Two を出力"]
    C -- "3" --> F["Three を出力"]
    D --> E
    E --> F
    F --> Z([終了])
```

## トレース表

| ステップ | 文 | x | マッチした case | 出力 |
|---|---|---|---|---|
| 1 | `int x = 2` | 2 | - | - |
| 2 | `switch (x)` | 2 | case 2 にジャンプ | - |
| 3 | `case 2: System.out.println("Two")` | 2 | 2 | Two |
| 4 | （break なし → fall through） | 2 | 3 | - |
| 5 | `case 3: System.out.println("Three")` | 2 | 3 | Three |

## 実行結果（標準出力）

```
Two
Three
```

## 学習ポイント

- `switch` は式の値に一致する `case` ラベルにジャンプする。
- `break` がないと、その後の case も**すべて**実行される（fall-through）。
- 通常は各 case の最後に `break` を入れる（→ `SampleSwitchBreak01`）。
