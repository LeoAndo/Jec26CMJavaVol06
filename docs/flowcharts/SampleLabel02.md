# SampleLabel02 — フローチャートとトレース表

- 対象ファイル: `src/vol06_02/SampleLabel02.java`
- パッケージ: `vol06_02`
- テーマ: ラベル付き `break outerLoop;` で外側ループも抜ける（外側で 1 行出力するパターン）。

## ソースの要点

```java
outerLoop: for (int i = 0; i < 3; i++) {
    System.out.println("i = " + i);
    for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) {
            break outerLoop;
        }
        System.out.println("    j=" + j);
    }
}
```

## フローチャート

```mermaid
flowchart TD
    A([開始]) --> B["i = 0 (outerLoop)"]
    B --> C{"i < 3 ?"}
    C -- Yes --> D["print i = + i"]
    D --> E["j = 0"]
    E --> F{"j < 3 ?"}
    F -- Yes --> G{"i==1 && j==1 ?"}
    G -- Yes --> M([終了 (break outerLoop)])
    G -- No --> H["print     j= + j"]
    H --> I["j++"]
    I --> F
    F -- No --> J["i++"]
    J --> C
    C -- No --> L([終了])
```

## トレース表

| ステップ | 外側 i | 内側 j | 条件 i==1 && j==1 | 出力 | コメント |
|----|----|----|----|----|----|
| 1 | 0 | - | - | `i = 0` | 外側に入る |
| 2 | 0 | 0 | false | `    j=0` | |
| 3 | 0 | 1 | false | `    j=1` | |
| 4 | 0 | 2 | false | `    j=2` | |
| 5 | 0 | 3 | - | （なし） | 内側 false → i++ |
| 6 | 1 | - | - | `i = 1` | |
| 7 | 1 | 0 | false | `    j=0` | |
| 8 | 1 | 1 | true | （なし） | **label で外側ループも抜ける** |

## 実行結果（標準出力）

```
i = 0
    j=0
    j=1
    j=2
i = 1
    j=0
```

## 学習ポイント

- 外側ループの先頭で `println("i = " + i)` を行うため、その出力は break 直前まで行われる。
- `break outerLoop;` は外側ループも完全に終了させる。
- 多重ループの「特定条件で全部抜けたい」場面で便利。
