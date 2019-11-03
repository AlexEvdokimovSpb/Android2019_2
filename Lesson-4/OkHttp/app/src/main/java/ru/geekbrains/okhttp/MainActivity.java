package ru.geekbrains.okhttp;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Получим наш элемент WebView
        final WebView page = findViewById(R.id.page);

        // создадим запрос при помощи нашего класса Requester, параметром зададим анонимный класс
        // с обратным вызовом по завершении работы
        OkHttpRequester requester = new OkHttpRequester(new OkHttpRequester.OnResponseCompleted() {
            // Это будет вызываться по завершении закачки страницы
            @Override
            public void onCompleted(String content) {
                page.loadData(content, "text/html; charset=utf-8", "utf-8");
            }
        });
        // Запустить запрос
        requester.run("https://geekbrains.ru"); // загрузим нашу страницу
    }
}
