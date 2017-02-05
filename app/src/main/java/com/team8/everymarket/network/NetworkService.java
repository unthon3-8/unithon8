package com.team8.everymarket.network;



import com.team8.everymarket.farm.FarmListData;
import com.team8.everymarket.farm.FarmResult;
import com.team8.everymarket.main.MainResult;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ichaeeun on 2017. 2. 5..
 */

public interface NetworkService {


    @GET("/request_farmers")
    Call<MainResult> getMainListData();


    @FormUrlEncoded
    @POST("/add_to_list") //장바구니에 농산물 추가
    Call<MainResult> addToList(@Field("ProductID") String productId,
                               @Field("CustomerID") int customerId);



    @FormUrlEncoded
    @POST("/show_product") // 판매자가 판매하는 모든 상품을 검색해서 JSON 배열로 돌려줍니다.
    Call<ArrayList> show_product(@Field("SellerID") String SellerID); // SellerID에는 한글로 농장이름을 넣으면 됩니다

    @FormUrlEncoded
    @POST("/request_shopping_list") //장바구니 리스트
    Call<ArrayList> requestShoppingList(@Field("CustomerID") String CustomerID); // 요청


    @FormUrlEncoded
    @POST("/delete_product") //장바구니 삭제
    Call<ArrayList> deleteProduct(@Field("CustomerID") String customerId,
                                   @Field("ProductID") int productId);


    @FormUrlEncoded
    @POST("/findProduct") //상품찾기
    Call<ArrayList> findProduct(@Field("ProductID") String productId);

    @FormUrlEncoded
    @POST("/find_order_list") //주문내역
    Call<ArrayList> findOrderList(@Field("ProductID") String productId);





}
