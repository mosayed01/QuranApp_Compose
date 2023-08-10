package com.mosayed.myapplication.data.remote

import com.mosayed.myapplication.data.remote.dto.aya.AyaDto
import com.mosayed.myapplication.data.remote.dto.aya.AyaResponseWrapper
import com.mosayed.myapplication.data.remote.dto.sura.SuraDto
import com.mosayed.myapplication.data.remote.dto.sura.SuraResponseWrapper
import com.mosayed.myapplication.data.remote.util.HttpRouts
import com.mosayed.myapplication.domain.model.Aya
import com.mosayed.myapplication.domain.model.Sura
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class QuranServiceImpl @Inject constructor(
    private val client: HttpClient
) : QuranService {
    override suspend fun getSura(): List<Sura> {
        val response: SuraResponseWrapper = client.get(HttpRouts.BASE_URL_SURA).body()
        return response.date?.toSuraList() ?: emptyList()
    }

    override suspend fun getAyat(number: Int): List<Aya> {
        val response: AyaResponseWrapper = client.get(HttpRouts.getAyatBySuraNumber(number)).body()
        return response.ayaDto.toAyat() ?: emptyList()
    }

    private fun AyaDto.toAya(): Aya {
        return Aya(
            arabicText = arabicText,
            aya = aya,
            footnotes = footnotes,
            id = id,
            sura = sura,
            translation = translation,
        )
    }

    private fun List<AyaDto>.toAyat(): List<Aya> = map { it.toAya() }

    private fun SuraDto.toSura(): Sura {
        return Sura(
            number = number ?: 0,
            name = name ?: "",
            englishName = englishName ?: "",
            englishNameTranslation = englishNameTranslation ?: "",
            numberOfAyahs = numberOfAyahs ?: 0,
            revelationType = revelationType ?: ""
        )
    }

    private fun List<SuraDto>.toSuraList(): List<Sura> = map { it.toSura() }
}