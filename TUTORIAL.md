# Java 基礎 Vol.06 - 制御構文 -

このテキストでは、Java の制御構文を学びます。
条件によって処理を分ける方法と、同じ処理を繰り返す方法を確認します。

---

## 目次

1. [はじめに](#1-はじめに)
2. [プロジェクト構成](#2-プロジェクト構成)
3. [条件分岐](#3-条件分岐)
4. [switch 文](#4-switch-文)
5. [三項演算子](#5-三項演算子)
6. [繰り返し](#6-繰り返し)
7. [break と continue](#7-break-と-continue)
8. [演習の進め方](#8-演習の進め方)

---

## 1. はじめに

### 1.1 前提条件

このテキストは、次の基本文法を学習済みの学生を対象にしています。

- クラスと `main` メソッド
- 変数とデータ型
- 標準出力
- 算術演算子
- キーボード入力の基本

### 1.2 学習目標

- `if` 文で条件に応じた処理を書ける
- 比較演算子と論理演算子を条件式で使える
- `switch` 文で複数の分岐を書ける
- `while`、`do-while`、`for` の違いを説明できる
- `break` と `continue` の動きを理解できる
- ネストした繰り返しを読める

---

## 2. プロジェクト構成

```
Jec26CMJavaVol06/
└── src/
    ├── SampleIf01.java
    ├── SampleIf02.java
    ├── SampleIf03.java
    ├── IfTest11.java
    ├── IfTest12.java
    ├── SampleSwitch01.java
    ├── SampleSwitchBreak01.java
    ├── SampleSwitchWithEnum.java
    ├── SampleConditional01.java
    ├── Test0501.java
    └── vol06_02/
        ├── SampleWhile01a.java
        ├── SampleWhile02.java
        ├── SampleDoWhile01.java
        ├── SampleFor01.java
        ├── SampleFor03.java
        ├── SampleBreak01.java
        ├── SampleContinue01.java
        ├── SampleLabel01.java
        └── Test0530.java
```

`src/` 直下のファイルはデフォルトパッケージです。
`vol06_02` 配下のファイルは `package vol06_02;` を持つため、実行時はクラス名の前に `vol06_02.` を付けます。

この教材には、文法エラーやスコープエラーを確認するために、あえてコンパイルできないファイルも含まれています。
全ファイルを一括コンパイルせず、授業で扱うファイルを 1 つずつコンパイル・実行してください。

```bash
# src 直下のクラス
javac src/SampleIf01.java
java -cp src SampleIf01

# vol06_02 パッケージのクラス
javac src/vol06_02/SampleFor01.java
java -cp src vol06_02.SampleFor01
```

---

## 3. 条件分岐

### 3.1 if 文

`if` 文は、条件式が `true` のときだけ処理を実行します。

```java
public class SampleIf01 {
    public static void main(String[] args) {
        int x = 10;
        if (x > 0) {
            System.out.println("xは正です。");
        }
    }
}
```

確認するファイル:

- `SampleIf01.java`
- `SampleIf02.java`
- `SampleIf03.java`
- `IfTest11.java` から `IfTest15.java`
- `IfTest21.java` から `IfTest23.java`
- `IfTest31.java` から `IfTest33.java`

`IfTest31.java` と `IfTest33.java` は、変数のスコープや再宣言のエラーを確認するための教材です。
コンパイルエラーの内容を読み、どの行が原因かを確認します。

### 3.2 条件式で使う演算子

| 種類 | 例 | 意味 |
|------|----|------|
| 比較演算子 | `x > 0` | `x` が 0 より大きい |
| 等価演算子 | `x == 10` | `x` が 10 と等しい |
| 論理 AND | `x > 0 && x < 10` | 両方の条件が成り立つ |
| 論理 OR | `x < 0 || x > 100` | どちらかの条件が成り立つ |
| 否定 | `!flag` | `flag` が `false` |

`=` は代入、`==` は比較です。条件式では間違えないように注意します。

---

## 4. switch 文

`switch` 文は、1 つの値に対して複数の分岐を作るときに使います。

```java
public class SampleSwitchBreak01 {
    public static void main(String[] args) {
        int x = 2;

        switch (x) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
        }
    }
}
```

`break` がない場合、次の `case` の処理も続けて実行されます。
この動きは `SampleSwitch01.java` と `SampleSwitchBreak01.java` を比較すると確認できます。

確認するファイル:

- `SampleSwitch01.java`
- `SampleSwitch02.java`
- `SampleSwitchBreak01.java`
- `SampleSwitchBreak01_.java`
- `SampleSwitchBreak02.java`
- `SampleSwitchWithEnum.java`
- `ColorEnum.java`
- `ColorEnum2.java`

`Test0516.java` は重複した `case`、`Test0522.java` は `switch` に使えない型を確認するための教材です。

---

## 5. 三項演算子

三項演算子は、条件によって代入する値を切り替える短い書き方です。

```java
max = (x > y) ? x : y;
```

上の式は、次の `if` 文と同じ意味です。

```java
if (x > y) {
    max = x;
} else {
    max = y;
}
```

確認するファイル:

- `SampleConditional01.java`

---

## 6. 繰り返し

### 6.1 while 文

`while` 文は、条件式が `true` の間、処理を繰り返します。

```java
int i = 1;
while (i <= 5) {
    System.out.println(i + "回目");
    i++;
}
```

確認するファイル:

- `vol06_02/SampleWhile01a.java`
- `vol06_02/SampleWhile01b.java`
- `vol06_02/SampleWhile02.java`
- `vol06_02/SampleWhile03.java`
- `vol06_02/SampleWhile04.java`

`vol06_02/SampleWhile04.java` は、ブロック内で宣言した変数をブロック外から使えないことを確認するための教材です。

### 6.2 do-while 文

`do-while` 文は、条件判定より先に処理を 1 回実行します。
そのため、条件が最初から `false` でも処理が 1 回は実行されます。

確認するファイル:

- `vol06_02/SampleDoWhile01.java`
- `vol06_02/SampleDoWhile02.java`

### 6.3 for 文

`for` 文は、回数が決まっている繰り返しでよく使います。

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i + "回目");
}
```

確認するファイル:

- `vol06_02/SampleFor01.java`
- `vol06_02/SampleFor02.java`
- `vol06_02/SampleFor03.java`
- `vol06_02/SampleFor03a.java` から `SampleFor03g.java`

---

## 7. break と continue

### 7.1 break

`break` は、繰り返しや `switch` を途中で終了します。

確認するファイル:

- `vol06_02/SampleBreak01.java`
- `vol06_02/SampleBreak02.java`
- `vol06_02/SampleBreak03.java`
- `vol06_02/SampleBreak04.java`

### 7.2 continue

`continue` は、現在の回だけ処理をスキップして、次の繰り返しに進みます。

確認するファイル:

- `vol06_02/SampleContinue01.java`
- `vol06_02/SampleContinue02.java`
- `vol06_02/SampleContinue03.java`

### 7.3 ラベル付き制御

ネストした繰り返しでは、ラベルを使って外側のループを制御できます。
ただし、読みづらくなりやすいため、必要な場合だけ使います。

確認するファイル:

- `vol06_02/SampleLabel01.java`
- `vol06_02/SampleLabel02.java`
- `vol06_02/SampleLabel03.java`
- `vol06_02/SampleLabel04.java`

---

## 8. 演習の進め方

### 8.1 条件分岐の確認問題

`src/` 直下の `Test0501.java` から `Test0522.java` を使います。
まず自分で実行結果を予想し、その後に実行して確認します。
一部のファイルはコンパイルエラーを確認する問題です。

```bash
javac src/Test0501.java
java -cp src Test0501
```

### 8.2 繰り返しの確認問題

`src/vol06_02/` 配下の `Test0530.java` から `Test0563.java` を使います。
一部のファイルは、未完成のコードや文法エラーを直す問題です。

```bash
javac src/vol06_02/Test0530.java
java -cp src vol06_02.Test0530
```

コンパイルエラーを確認する教材の例:

| ファイル | 確認する内容 |
|---------|--------------|
| `Test0504.java` | Java では `-5 < x < 5` のような連続比較を書けない |
| `IfTest31.java` | ブロック内で宣言した変数のスコープ |
| `IfTest33.java` | 同じスコープでの変数再宣言 |
| `Test0516.java` | `case` ラベルの重複 |
| `Test0522.java` | `switch` に使えない型 |
| `vol06_02/SampleWhile04.java` | ブロック内変数のスコープ |
| `vol06_02/Test0540.java` | `do-while` の条件式は boolean である必要がある |
| `vol06_02/Test0548.java` | `for` 文の初期化、条件式、更新式 |
| `vol06_02/Test0554.java` | ラベル付き `continue` のラベル名 |

### 8.3 学習時の確認ポイント

- 条件式が `true` になる値と `false` になる値を確認する
- `switch` の `break` を外した場合の動きを確認する
- `while` と `do-while` の違いを確認する
- `for` 文の初期化、条件式、更新式の順番を確認する
- `break` と `continue` が実行された後、次にどの行へ進むかを追う

---

## まとめ

制御構文を使うと、プログラムは上から順番に実行するだけでなく、条件に応じて分岐したり、同じ処理を繰り返したりできます。
サンプルコードは短いものから順に実行し、変数の値を少し変えて動きの違いを確認してください。
