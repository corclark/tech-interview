package com.specialized.android

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


interface CoroutineGearRepository {
    suspend fun getGear(): Flow<List<GearItem>>
}

class CoroutineGearRepositoryImpl(
    private val gearApi: GearApi,
    private val gearDao: GearDao,
) : CoroutineGearRepository {

    override suspend fun getGear(): Flow<List<GearItem>> {
        return flowOf()
    }
}