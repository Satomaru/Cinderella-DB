# Cinderella-DB

アイドルマスターシンデレラガールズのデータベースを作りたいなあ (願望)

## 開発環境

Pleiades All in One Eclipse<br>
https://mergedoc.osdn.jp/

MySQL<br>
https://www.mysql.com/jp/

## 注意事項

本プロジェクトは現在、開発を始めたばかりです。

MySQLは公開していませんので、動かしてみたい人は、自力でMySQLを用意して、
`src/main/resources/application.properties` を修正してください。


## 現在の状況

PCにPleiadesとMySQLをインストールした。

Spring Bootの勉強を始める。(そこからかよw)

MySQLに `idols` テーブルを作成。

    CREATE TABLE `idols` (
        `id` int NOT NULL,
        `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
        `kana` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
        PRIMARY KEY (`id`),
        KEY `kana` (`kana`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

以下のURLで、アイドル一覧が取得できるのを確認。

    http://localhost:8080/idol/all
