# VotingApp
## モック
https://prottapp.com/p/6f84ec
## 環境構築
### AndroidStudioで行う
#### 手順
1. `File` -> `New` -> `Project from Version Control` -> `GitHub`
2. パスワードを求められたらGitHubアカウントのパスワードを入力
3. `Git Repository URL` に下記を貼り付け
    - `git@github.com:working-group/VotingApp.git`
4. `test`　を実行
5. `Parent Directory` 、`Directory Name`を入力
6. `Clone` をクリック

プロジェクトが開いたらエミュレータでアプリを起動してみて動作確認を行う

## 開発手順
### AndroidStudioで行う
#### 手順
1. `Terminal` を開く
2. `git branch` コマンドで現在のブランチを確認
    - `develop` ブランチにいない場合、下記コマンドを実行
      - `git checkout develop`
      - `git pull`
3. `git checkout -b feature-hoge`
    - `hoge` をつけたいブランチ名に置き換えてコマンドを実行
4. 実装
5. `git status` コマンドで変更ファイルを確認
6. `git diff` コマンドで変更内容を確認
7. `git add hoge/hoge/hoge.java` コマンドで変更ファイルをインデックスに登録
    - `hoge` を変更ファイルに置き換えて実施
8. 再度`git status` コマンドで必要なファイルのみがインデックス登録されているか確認
9. `git commit` コマンドでインデックス登録したファイルをコミット
    - vimが開かれるので１行目にコミットメッセージを入力し、保存して閉じる
      - `i` インサートモードに切り替え
      - `esc` インサートモード終了
      - `:wq` 保存して閉じる
10. `git push -u origin feature-hoge:feature-hoge` コマンドでコミット内容をプッシュ
    - 同ブランチで２回目以降のプッシュは `git push` のみでおk
11. `https://github.com/working-group/VotingApp` にアクセス
12. `create pull request` 的なのが表示されているはずなのでそれをクリック
13. プルリクエストを作成する

~~14. 誰かにプルリクエストのレビューを依頼~~

~~15. レビュワーがブランチをマージしてくれたら完了~~

14. プルリクのマージボタンを押下
  - masterブランチに編集中のブランチが統合される

`1.`に戻って別のタスクを開始
