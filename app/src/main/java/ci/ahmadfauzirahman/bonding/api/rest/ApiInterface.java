package ci.ahmadfauzirahman.bonding.api.rest;


import ci.ahmadfauzirahman.bonding.adapter.KusionerSoalAdapter;
import ci.ahmadfauzirahman.bonding.api.response.AkunResponse;

import ci.ahmadfauzirahman.bonding.api.response.ArtikelResponse;
import ci.ahmadfauzirahman.bonding.api.response.CheckJawabanEPDSResponse;
import ci.ahmadfauzirahman.bonding.api.response.DiaryIbuResponse;
import ci.ahmadfauzirahman.bonding.api.response.InformasiConsentResponse;
import ci.ahmadfauzirahman.bonding.api.response.LpgdResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("v1/auth/index")
    Call<AkunResponse> login(
            @Field("no_telp") String no_telp,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("v1/auth/register")
    Call<AkunResponse> daftar(
            @Field("no_telp") String no_telp,
            @Field("nama_lengkap") String nama_lengkap,
            @Field("email") String email,
            @Field("password") String password
    );


    @GET("v1/daftar-instrumen/informasi?=id")
    Call<InformasiConsentResponse> getInformasi(
            @Query("id") String id
    );

    @GET("v1/daftar-instrumen/diary-ibu")
    Call<DiaryIbuResponse> getDiaryIbu(
            @Query("id") String id
    );

    @GET("v1/daftar-instrumen/check-responden-data")
    Call<CheckJawabanEPDSResponse> getCheck(
            @Query("id") String id
    );

    @GET("v1/daftar-instrumen/lpgd-list")
    Call<LpgdResponse> getSoal(
            @Query("id") String id
    );

    @GET("v1/artikel")
    Call<ArtikelResponse> getArtikel();

    @FormUrlEncoded
    @POST("v1/auth/forget-password")
    Call<AkunResponse> lupa(
            @Field("no_hp") String no_hp,
            @Field("password_baru") String password_baru,
            @Field("password_confirm_baru") String password_confirm_baru
    );

    @FormUrlEncoded
    @POST("v1/diary/save-diary")
    Call<DiaryIbuResponse> diaryIbu(
            @Field("nik") String nik,
            @Field("perasaan") String perasaan);

}
