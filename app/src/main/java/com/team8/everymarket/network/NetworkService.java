package com.team8.everymarket.network;



import com.team8.everymarket.main.MainResult;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;


public interface NetworkService {



/*

    @GET("/request_farmers")
    Call<MainResult> getMainListData();

    @GET("/posts/{id}")
    Call<DetailResult> getDetailData(@Path("id") int id);

    @Multipart
    @POST("/posts")
    Call<RegisterResult> registerImgNotice(@Part MultipartBody.Part file,
                                           @Part("title") RequestBody title,
                                           @Part("contents") RequestBody content,
                                           @Part("owner") RequestBody owner);

    @FormUrlEncoded
    @POST("/login") //메써드 (요청경로)
    Call<MainResult> getMainData(@Field("user_id") String user_id,
                                 @Field("passwd") String passwd,
                                 @Field("case") int caseNum); // 요청

    */
/** 플레이리스트에 음악추가*//*

    @FormUrlEncoded
    @POST("/playlists") //메써드 (요청경로)
    Call<MainResult> requestAddMusic(@Field("user_id") String user_id,
                                     @Field("music_id") int music_id);

    */
/** 플레이리스트 음악 삭제 *//*

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "/playlists", hasBody = true)
    Call<MainResult> deleteMusic(@Field("user_id") String user_id,
                                 @Field("music_id") int music_id);
*/



}
