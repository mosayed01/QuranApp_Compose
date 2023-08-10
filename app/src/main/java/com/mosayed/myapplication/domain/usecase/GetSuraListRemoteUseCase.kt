package com.mosayed.myapplication.domain.usecase

import com.mosayed.myapplication.data.remote.QuranService
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetSuraListRemoteUseCase @Inject constructor(
    private val service: QuranService
) {
    suspend operator fun invoke() = service.getSura()
}