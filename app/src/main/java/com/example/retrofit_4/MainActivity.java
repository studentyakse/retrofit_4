package com.example.retrofit_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    public class Item {
        private String login;
        private int id;
        private String avatarUrl;
        private String gravatarId;
        private String url;
        private String htmlUrl;
        private String followersUrl;
        private String followingUrl;
        private String gistsUrl;
        private String starredUrl;
        private String subscriptionsUrl;
        private String organizationsUrl;
        private String reposUrl;
        private String eventsUrl;
        private String receivedEventsUrl;
        private String type;
        private boolean siteAdmin;
        private float score;

        /**
         * @return The login
         */
        public String getLogin() {
            return login;
        }

        /**
         * @param login The login
         */
        public void setLogin(String login) {
            this.login = login;
        }

        /**
         * @return The id
         */
        public int getId() {
            return id;
        }

        /**
         * @param id The id
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * @return The avatarUrl
         */
        public String getAvatarUrl() {
            return avatarUrl;
        }

        /**
         * @param avatarUrl The avatar_url
         */
        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        /**
         * @return The gravatarId
         */
        public String getGravatarId() {
            return gravatarId;
        }

        /**
         * @param gravatarId The gravatar_id
         */
        public void setGravatarId(String gravatarId) {
            this.gravatarId = gravatarId;
        }

        /**
         * @return The url
         */
        public String getUrl() {
            return url;
        }

        /**
         * @param url The url
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * @return The htmlUrl
         */
        public String getHtmlUrl() {
            return htmlUrl;
        }

        /**
         * @param htmlUrl The html_url
         */
        public void setHtmlUrl(String htmlUrl) {
            this.htmlUrl = htmlUrl;
        }

        /**
         * @return The followersUrl
         */
        public String getFollowersUrl() {
            return followersUrl;
        }

        /**
         * @param followersUrl The followers_url
         */
        public void setFollowersUrl(String followersUrl) {
            this.followersUrl = followersUrl;
        }

        /**
         * @return The followingUrl
         */
        public String getFollowingUrl() {
            return followingUrl;
        }

        /**
         * @param followingUrl The following_url
         */
        public void setFollowingUrl(String followingUrl) {
            this.followingUrl = followingUrl;
        }

        /**
         * @return The gistsUrl
         */
        public String getGistsUrl() {
            return gistsUrl;
        }

        /**
         * @param gistsUrl The gists_url
         */
        public void setGistsUrl(String gistsUrl) {
            this.gistsUrl = gistsUrl;
        }

        /**
         * @return The starredUrl
         */
        public String getStarredUrl() {
            return starredUrl;
        }

        /**
         * @param starredUrl The starred_url
         */
        public void setStarredUrl(String starredUrl) {
            this.starredUrl = starredUrl;
        }

        /**
         * @return The subscriptionsUrl
         */
        public String getSubscriptionsUrl() {
            return subscriptionsUrl;
        }

        /**
         * @param subscriptionsUrl The subscriptions_url
         */
        public void setSubscriptionsUrl(String subscriptionsUrl) {
            this.subscriptionsUrl = subscriptionsUrl;
        }

        /**
         * @return The organizationsUrl
         */
        public String getOrganizationsUrl() {
            return organizationsUrl;
        }

        /**
         * @param organizationsUrl The organizations_url
         */
        public void setOrganizationsUrl(String organizationsUrl) {
            this.organizationsUrl = organizationsUrl;
        }

        /**
         * @return The reposUrl
         */
        public String getReposUrl() {
            return reposUrl;
        }

        /**
         * @param reposUrl The repos_url
         */
        public void setReposUrl(String reposUrl) {
            this.reposUrl = reposUrl;
        }

        /**
         * @return The eventsUrl
         */
        public String getEventsUrl() {
            return eventsUrl;
        }

        /**
         * @param eventsUrl The events_url
         */
        public void setEventsUrl(String eventsUrl) {
            this.eventsUrl = eventsUrl;
        }

        /**
         * @return The receivedEventsUrl
         */
        public String getReceivedEventsUrl() {
            return receivedEventsUrl;
        }

        /**
         * @param receivedEventsUrl The received_events_url
         */
        public void setReceivedEventsUrl(String receivedEventsUrl) {
            this.receivedEventsUrl = receivedEventsUrl;
        }

        /**
         * @return The type
         */
        public String getType() {
            return type;
        }

        /**
         * @param type The type
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * @return The siteAdmin
         */
        public boolean isSiteAdmin() {
            return siteAdmin;
        }

        /**
         * @param siteAdmin The site_admin
         */
        public void setSiteAdmin(boolean siteAdmin) {
            this.siteAdmin = siteAdmin;
        }

        /**
         * @return The score
         */
        public float getScore() {
            return score;
        }

        /**
         * @param score The score
         */
        public void setScore(float score) {
            this.score = score;
        }
    }

    public class GitResult {
        private int totalCount;
        private boolean incompleteResults;
        private List<Item> items = new ArrayList<>();

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public boolean isIncompleteResults() {
            return incompleteResults;
        }

        public void setIncompleteResults(boolean incompleteResults) {
            this.incompleteResults = incompleteResults;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }
    }

    interface GitHubService {

        // GET /search/users

        @GET("/search/users")
        Call<GitResult> getUsers(@Query("q") String name);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void onClick(View view) {
        mProgressBar.setVisibility(View.VISIBLE);

        GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
        // часть слова
        final Call<GitResult> call =
                gitHubService.getUsers("alexanderklim");

        call.enqueue(new Callback<GitResult>() {
            @Override
            public void onResponse(Call<GitResult> call, Response<GitResult> response) {
                // response.isSuccessful() is true if the response code is 2xx
                if (response.isSuccessful()) {
                    GitResult result = response.body();

                    // Получаем json из github-сервера и конвертируем его в удобный вид
                    // Покажем только первого пользователя
                    String user = "Аккаунт Github: " + result.getItems().get(0).getLogin();
                    mTextView.setText(user);
                    Log.i("Git", String.valueOf(result.getItems().size()));

                    mProgressBar.setVisibility(View.INVISIBLE);
                } else {
                    int statusCode = response.code();

                    // handle request errors yourself
                    ResponseBody errorBody = response.errorBody();
                    try {
                        mTextView.setText(errorBody.string());
                        mProgressBar.setVisibility(View.INVISIBLE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<GitResult> call, Throwable throwable) {
                mTextView.setText("Что-то пошло не так: " + throwable.getMessage());
            }
        });
    }

}