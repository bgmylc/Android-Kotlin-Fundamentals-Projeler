package com.begumyolcu.devbytes_starter.network

import com.begumyolcu.devbytes_starter.domain.DevByteVideo
import com.squareup.moshi.JsonClass

/**
 * DataTransferObjects bu dosyada olmalıdır. Bunlar, sunucudan gelen yanıtları parse etmekten
 * veya sunucuya gönderilecek nesneleri biçimlendirmekten sorumludur. Bunları kullanmadan
 * önce domain nesnelerine dönüştürmelisiniz.
 *
 * @see domain -> domain paketine bakın
 */

/**
 * VideoHolder bir Videos listesi tutar
 *
 * Bu, şuna benzeyen ağ sonucumuzun ilk seviyesini parse etmek içindir.
 *
 * {
 *   "videos": []
 * }
 */
@JsonClass(generateAdapter = true)
data class NetworkVideoContainer(val videos: List<NetworkVideo>)

/**
 * Videos, oynatılabilen bir devbyte'ı temsil eder.
 */
@JsonClass(generateAdapter = true)
data class NetworkVideo(
    val title: String,
    val description: String,
    val url: String,
    val updated: String,
    val thumbnail: String,
    val closedCaptions: String?)

/**
 * Ağ (Netework) sonuçlarını veritabanı nesnelerine dönüştürün.
 */
fun NetworkVideoContainer.asDomainModel(): List<DevByteVideo> {
    return videos.map {
        DevByteVideo(
            title = it.title,
            description = it.description,
            url = it.url,
            updated = it.updated,
            thumbnail = it.thumbnail)
    }
}