package hyee.hyi.hi.hyiiiiiiiiii;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by nkzt on 2015/11/13.
 */
public class HyiActivity extends Activity { // AndroidフレームワークのActivityを継承(extends)してるぞ！Activityは大体の場合、layoutのxmlファイルとjavaファイルを紐付ける役目を持つ・・・！

    @Override // ←はオーバーライドメソッドにつけれる目印のようなものだ！@といえば、pythonではデコレータとかいうよくわからないやつだが、javaではアノテーションというよくわからないやつだ！
    public void onCreate(Bundle savedInstanceState) { // Activityクラスにはライフサイクルというものがあって、onCreateはその中で最初に呼ばれる！
                                                      // onCreateの引数のBundleはディクショナリ的な働きをするクラスと言ったほうがpythonエンジニアの君たちに理解してもらいやすいだろうか・・・！まぁ普通はほぼ使わないけどね・・・！
        // 以下の2行はほとんどのActivityのサブクラスの初めに書かれているものだ。基本的な設定をここで行うことになる！
        super.onCreate(savedInstanceState); // onCreate等のライフサイクルメソドの多くはオーバーライドする時にはスーパークラスのメソッドを呼ばないといけないのだ・・！
        setContentView(R.layout.hyi_activity); // このActivityのベースレイアウトを設定してるぞ！このsetContentViewをあえて呼ばないことで、レイアウトを持たないActivityの定義も可能となる・・・！

        // ここから下の行では、layoutファイルに配置したViewと呼ばれるUIパーツを取得したり、その振る舞いを定義したりするぞ！
        final LinearLayout mRootLayout = (LinearLayout) findViewById(R.id.hyiRootLayout);// LinearLayoutはViewGroupという種類のViewだ！Viewの入れ物と言ってもいいだろう。ViewGroupは複数あり、それぞれのルールでその配下のViewの配置を決定する・・・！
        Button hyiButton = (Button) findViewById(R.id.hyiButton);// ButtonというViewだ！その存在意義たるやまさにボタン！ボタン的なUI、ボタン的な動作を定義できるぞ！
        hyiButton.setOnClickListener(new View.OnClickListener() {// 上の行で取得したhyiButtonをクリックした時の振る舞いをセットしているぞ！setOnClickListenerでonClickをオーバーライドしたView.OnClickListenerをhyiButtonにセット！
            @Override// そう、onClick(View v)はOnClickListenerインターフェースのをオーバーライドしているのだ・・！
            public void onClick(View v) {// このメソッドにクリック時の処理を記述するぞ！引数の(View v)は、OnClickListenerをsetしたViewの事だ！つまり、今回で言えばhyiButtonが引数としてonClickに渡されることになる・・・！
                TextView hyiText = new TextView(HyiActivity.this);// この行でTextViewを新しく生成している。TextViewとは文字通りテキストの表示に特化したViewのことだ！
                hyiText.setText(getString(R.string.hyi));// 上の行で生成したTextViewにstrings.xmlで定義した文字列をセットしている。
                mRootLayout.addView(hyiText);// 23行目で取得したmRootLayoutに今しがた生成したTextViewを打ち込んでるところだ！LinearLayoutであり、xmlでandroid:orientation="vertical"を設定しているので垂直方向に追加されるぞ！
            }
        });
    }
}
