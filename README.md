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

以下のURLで、アイドルが取得できるのを確認。

    http://localhost:8080/cinderella/api/idols/
    http://localhost:8080/cinderella/api/idols/?type=Cu
    http://localhost:8080/cinderella/api/idols/?kana=みりあ
    http://localhost:8080/cinderella/api/idols/?type=Cu&kana=いち
    http://localhost:8080/cinderella/api/idols/15
