# SampleBreak02 — フローチャートとトレース表

- 対象ファイル: `src/vol06_02/SampleBreak02.java`
- パッケージ: `vol06_02`
- テーマ: switch 文での `break` の使い方（ループではない break の例）。

## ソースの要点

```java
int i = 2;
switch (i) {
    case 1:
        System.out.println("iは1です。");
        break;
    case 2:
        System.out.println("iは2です。");
        break;
    default:
        System.out.println("iは3です。");
        break;
}
```

## フローチャート

```mermaid
flowchart TD
    A([開始]) --> B["i = 2"]
    B --> C{"switch (i)"}
    C -- "case 1" --> D["print iは1です。"]
    D --> H([終了 (break)])
    C -- "case 2" --> E["print iは2です。"]
    E --> H
    C -- "default" --> F["print iは3です。"]
    F --> H
```

## トレース表

| ステップ | 文 | i | 出力 | コメント |
|----|----|----|----|----|
| 1 | `int i = 2;` | 2 | （なし） | |
| 2 | `switch (i)` | 2 | （なし） | i==2 で case 2 へ分岐 |
| 3 | `println("iは2です。")` | 2 | `iは2です。` | |
| 4 | `break;` | 2 | （なし） | switch を抜ける |

## 実行結果（標準出力）

```
iは2です。
```

## 学習ポイント

- `break` は switch 文の中でも使われ、その case の処理を終えて switch を抜ける。
- break が無いと次の case の処理に「フォールスルー」してしまう。
- ループの break と書き方は同じだが、役割が異なる点に注意。
