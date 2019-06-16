package com.example.culturio.Retrofit;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface INodeJS {

    @POST("museo/lider")
    @FormUrlEncoded
    Observable<String> datosLider(@Field("idmuseo") Integer idmuseo);

    @POST("museo/nuevolider")
    @FormUrlEncoded
    Observable<String> nuevoLider(@Field("idmuseo") Integer idmuseo,
                                  @Field("nombre") String nombre,
                                  @Field("img") String img,
                                  @Field("face") String face,
                                  @Field("puntos") Integer puntos);
}
