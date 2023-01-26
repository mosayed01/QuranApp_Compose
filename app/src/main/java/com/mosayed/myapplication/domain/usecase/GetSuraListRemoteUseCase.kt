package com.mosayed.myapplication.domain.usecase

import com.mosayed.myapplication.data.remote.QuranService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetSuraListRemoteUseCase @Inject constructor(
    private val service: QuranService
) {
    suspend operator fun invoke() = withContext(Dispatchers.IO) { service.getSura() }
}